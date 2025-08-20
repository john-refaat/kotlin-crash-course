package inlinefunctions

class Email(val title: String)
fun getEmail(): Email? {
    print("Email Title: ")
    val title = readln()
    return if (title.trim() != "") Email(title) else null
}

fun sendEmail(email: Email) {
    println("Sending Email ${email.title}")
}

open class User(open val id: Int)

data class FacebookUser(override val id: Int, val username: String): User (id)

interface Session {
    val user: User
}

class UserSession(override val user: User) : Session

fun analyzeUserSession(session: Session) {
    val user = session.user
//    if (user is FacebookUser) {
//        println(user.username)
//    }
    (session.user as? FacebookUser)?.let {
        println(it.username)
    }
}

fun main() {
//    val email = getEmail()
//    //if (email!=null) sendEmail(email)
//    email?.let { sendEmail(it) }

    analyzeUserSession(UserSession(FacebookUser(2332, "john")))
}
