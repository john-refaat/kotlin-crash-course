package words

class Words {
    private val list = mutableListOf<String>()

    fun String.record() {
        list += this
    }

    fun initialize() {
        "foo".record()
    }

    operator fun String.unaryPlus() {
        record()
    }

    override fun toString() = list.toString()
}

fun main() {
    val words = Words()
    words.initialize()
    with(words) {
        "one".record()
        +"two"
        +"three"
    }
    println(words)
}