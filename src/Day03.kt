
fun main() {
    fun day3(data: List<String>,  x:Int, y:Int): Long {
        var count = 0L
        for (i in data.indices step y) {
            if (data[i][((x * i)/y % data.first().length)] == '#') count++
        }
        return count
    }

    val testInput = readInput("Day03Test")
    val input = readInput("Day03")
    //part1
    println(day3(testInput, x =3, y = 1))
    println(day3(input, x = 3, y=1))

    /*
     part2
     Right 1, down 1.
     Right 3, down 1.
     Right 5, down 1.
     Right 7, down 1.
     Right 1, down 2.
     */
    println(
        day3(testInput, x = 1, y=1) * day3(testInput, x = 3, y=1 ) * day3(testInput, x = 5, y=1) *
                day3(testInput, x = 7, y=1) * day3(testInput, x = 1, y=2)
    )
    println(
        (day3(input, x = 1, y=1) * day3(input, x = 3, y=1 ) * day3(input, x = 5, y=1) *
                day3(input, x = 7, y=1) * day3(input, x = 1, y=2))
    )
}