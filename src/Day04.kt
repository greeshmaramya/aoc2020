fun main() {
    fun List<String>.modifyInput(): MutableList<String> {
        val passports: MutableList<String> = mutableListOf()
        var s = ""
        forEach {
            if (it.isBlank()) {
                passports.add(s)
                s = ""
            } else {
                s += " "
                s += it
            }
        }
        passports.add(s)
        return passports
    }

    fun String.valid1(): Boolean {
        return contains("byr")
                && contains("iyr")
                && contains("eyr")
                && contains("hgt")
                && contains("hcl")
                && contains("ecl")
                && contains("pid")
    }
    fun Pair<String, String>.valid2(): Boolean {
        return when (first) {
            "byr" -> second.toInt() in 1920..2002
            "iyr" -> second.toInt() in 2010..2020
            "eyr" -> second.toInt() in 2020..2030
            "hgt" -> {
                val height = second.filter { it.isDigit() }.toInt()
                return if (second.contains("cm")) {
                    height in 150..193
                } else {
                    height in 59..76
                }
            }
            "hcl" -> { val p = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$".toRegex()
                p.matches(second)
            }
            "ecl" -> {
                second == "amb" || second == "blu" || second == "brn" ||
                        second == "gry" || second == "grn" || second == "hzl" || second == "oth"
            }
            "pid" -> second.length == 9 && second.matches(Regex("[0-9]+"))
            else -> true
        }
    }

    fun part1(input: List<String>): Int = input.modifyInput().count { it.valid1() }

    fun part2(input: List<String>) {
        var count = 0
        var valid2 = true
        val p = input.modifyInput()
        val s = input.modifyInput().map { it.trim() }.map { it.split(" ") }
            .map { it1 -> it1.map { Pair(it.split(':').first(), it.split(':').last()) } }
        s.forEachIndexed { index, it ->
            for (i in it.indices) {
                if (!it[i].valid2()) valid2 = false
            }
            if (p[index].valid1() && valid2) count++
            valid2 = true
        }
        println(count)
    }
    val testInput = readInput("Day04Test")
    val input = readInput("Day04")

    println(part1(input))
    part2(testInput)
    part2(input)
}
