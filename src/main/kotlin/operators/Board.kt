package operators

data class Board(val rows:Int, val cols: Int) {

    val matrix = Array(rows) { CharArray(cols) }

}

fun Board.display() {
    (0 until rows).forEach { row ->
        (0 until cols).forEach { col ->
            print("${this[row, col]} ")
        }
        println()
    }
}

operator fun Board.set(row: Int, col: Int, c: Char ) {
    if (row < rows && col < cols)
        matrix[row][col] = c
}

operator fun Board.get(row: Int, col: Int):Char? {
    return if (row < rows && col < cols) matrix[row][col] else null
}

fun main() {
    val board = Board(2, 3)
    board[0, 0] = 'X'
    board[0, 1] = 'X'
    board[0, 2] = 'X'

    board[1, 0] = 'O'
    board[1, 1] = 'X'
    board[1, 2] = 'O'

    board.display()
    println(board[1, 2])
}