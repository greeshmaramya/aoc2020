fun main() {
    fun String.modify(): String = replace('B', '1').replace('F', '0')
        .replace('R', '1').replace('L', '0')

    fun String.getSeatId(): Int {
        val row = modify().substring(0, 7).toInt(2)
        val column = modify().substring(7).toInt(2)
        return row * 8 + column
    }

    fun sum(n: Int) = (n * (n + 1)) / 2

    fun day5(input: List<Int>) {
        val maxSeatId = input.maxOrNull() ?: 0
        val minSeatId = input.minOrNull() ?: 0
        val missingSeatId = (sum(maxSeatId) - sum(minSeatId - 1)) - input.sum()
        println(maxSeatId) //part1
        println(missingSeatId) //part2
    }

    val testInput = readInput("Day05Test").map { it.getSeatId() }
    val input = readInput("Day05").map { it.getSeatId() }
    day5(testInput)
    day5(input)
}