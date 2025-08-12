package properties

data class MyData(val name: String)

open class Activity

class KotlinActivity: Activity() {
    //lateinit cannot be used for nullable references or primitive types
    //lateinit var myData: MyData?
    //lateinit var n:Int
    //Not allowed with val
    //lateinit val myData1: MyData
    lateinit var myData: MyData

    fun onCreate() {
        println("initialized: ${this::myData.isInitialized}")
        myData = MyData("ABC")
        println("initialized: ${this::myData.isInitialized}")
    }

    fun foo() {
        println(myData.name)
    }
}

fun main() {
    val activ = KotlinActivity()
    //println(activ.myData)
    activ.onCreate()
    println(activ.myData)
}