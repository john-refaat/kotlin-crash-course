package properties

val foo1 = run {
    println("Calculating the answer...")
    42
}

val bar = {
    println("Calculating the answer...")
    42
}

val foo2: Int
    get() {
        println("Calculating the answer")
        return 42
    }

enum class State {ON, OFF}

class StateLogger {
    var state = false
        set(value) {
            println("State has changed from $field to $value")
            field = value
        }
}

class StateLogger2 {
    private var boolState = false

    var state: State
        get() = if (boolState) State.ON else State.OFF
        set(value) {
            boolState = value == State.ON
        }
}

open class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }

}

interface User {
    val nickname: String
}

fun getFacebookName(accountId: Int): String {
    println("Get Facebook Name")
    return "Blue Moon"
}

class FacebookUser(val accountId: Int): User {
    override val nickname: String = getFacebookName(accountId)
}

class SubscribingUser(val email: String): User {
    override val nickname: String
        get() {
            println("Get Nickname")
            return email.substringBefore('@')
        }
}

interface Session {
    val user: User
}

class WebSession(override val user: User) : Session {

}

fun analyzeUserSession(session: Session) {
    if (session.user is FacebookUser) {
        //Smart cast does not apply
        println((session.user as FacebookUser).accountId)
    }
}

fun analyzeUserSession2(session: Session) {
    val user = session.user
    if (user is FacebookUser) {
        // Smart Cast applies
        println(user.accountId)
    }
}

fun main() {
    println("Foo1")
    println("$foo1 $foo1")
    println("Bar")
    println("$bar $bar")
    println(bar())
    println("Foo2")
    println("$foo2 $foo2")

    println("State Logger:")
    val stateLogger = StateLogger()
    stateLogger.state = true
    println(stateLogger.state)

    println("State Logger 2:")
    val stateLogger2  = StateLogger2()
    println(stateLogger2.state)
    stateLogger2.state = State.ON
    println(stateLogger2.state)

    val lenCounter = LengthCounter()
    println(lenCounter.counter)
    lenCounter.addWord("abc")
    println(lenCounter.counter)
    lenCounter.addWord("def")
    println(lenCounter.counter)

    val user = FacebookUser(23456123)
    println(user.nickname)
    println(user.nickname)

    val user2 = SubscribingUser("foo@bar.com")
    println(user2.nickname)
    println(user2.nickname)

    analyzeUserSession(WebSession(user))

}