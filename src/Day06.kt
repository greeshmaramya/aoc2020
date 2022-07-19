fun main() {
    fun day06(data: List<String>) {
        var part1 = 0
        var part2 = 0
        val h = HashMap<Char, Int>()
        val ans = data.joinToString(",").split(",,").map { it.split(',') }
        ans.forEach { group ->
            if (group.size == 1) {
                part1 += group.first().length
                part2 += group.first().length
            } else {
                group.forEach { it.forEach { c -> h[c] = h.getOrDefault(c, 0) + 1 } }
                part1 += h.size
                part2 += h.filter { it.value == group.size }.size
            }
            h.clear()
        }
        println(part1)
        println(part2)
    }

    /* -------------  Alternate Solution ------------- */
    fun day06AlternateP1(data: List<String>) {
        var c = 0
        val modifiedData = data.joinToString(",").split(",,").map { it.replace(",", "") }
        modifiedData.forEach { c += it.toSet().size }
        println(c)
    }

    fun day06AlternateP2(data: List<String>) {
        var c = 0
        val ans = data.joinToString(",").split(",,").map { it.split(',') }
        ans.forEach {
            if (it.size == 1) {
                c += it.first().length
            } else {
                var s = it[0].toSet()
                for (j in it) {
                    s = s.intersect(j.toSet())
                }
                c += s.size
            }
        }
        println(c)
    }

    val testInput = readInput("Day06Test")
    val input = readInput("Day06")
    day06(testInput)
    day06(input)

    day06AlternateP1(testInput)
    day06AlternateP1(input)
    day06AlternateP2(testInput)
    day06AlternateP2(input)
}