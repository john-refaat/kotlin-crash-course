package lambdawithreceiver

import java.math.BigInteger.ZERO


//==========================================================//
//                 ||   { .. this .. }       { .. it .. }   //
//==========================================================//
// return result   ||      with/run               let       //
// of Lambda       ||                                       //
//                 ||                                       //
//                 ||                                       //
// return receiver ||       apply                 also      //
//==========================================================//

data class Window(var width:Int, var height: Int, var isVisible: Boolean)

fun showWindow(window: Window) {
    println("showing $window")
}

fun main() {
    val map = mapOf("main" to Window(300, 200, true))
    val windowOrNull = map["main"]
    windowOrNull?.run {
        width = 600
        height = 400
        isVisible = false
    }
    println(windowOrNull)

    // apply returns the receiver object
    val mainWin = windowOrNull?.apply {
        width = 450
        height = 300
        isVisible = true
    }?:return
    println(mainWin)

    windowOrNull?.apply {
        width = 450
        height = 300
        isVisible = true
    }?.also {
        showWindow(it)
    }
    println(mainWin)

    val abc = with(windowOrNull) {
        showWindow(this)
        "abc"
    }
    println("abc: $abc")

    val b = windowOrNull?.let {
        showWindow(it)
        ZERO
    }
    println("b: $b")

}