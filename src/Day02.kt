data class Day2(
    val password: String,
    val l: Int,
    val r: Int,
    val c: Char
)


fun main() {

    fun String.modifyInput(): Day2 {
        val s = split(':')
        val s1 = s.first().split(' ')
        val s2 = s1.first().split('-')
        return Day2(password = s.last(), l = s2.first().toInt(), r = s2[1].toInt(), c = s1.last().last())
    }

    fun part1(data: List<Day2>):Int {
        var count = 0
        data.forEach { db ->
            val num = db.password.count { it == db.c }
            if (db.l <= num && num <= db.r) {
                count++
            }
        }
        return count
    }


    fun part2(data: List<Day2>):Int {
        var count = 0
        data.forEach {
            if( (it.password[it.l] == it.c) xor (it.password[it.r] == it.c)) count++
        }
        return count
    }


    val testInput = readInput("Day02Test").map { it.modifyInput() }
    val input = readInput("Day02").map { it.modifyInput() }
    println(part1(testInput))
    println(part1(input))

    println(part2(testInput))
    println(part2(input))
}