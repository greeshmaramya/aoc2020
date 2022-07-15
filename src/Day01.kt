fun main() {
    val testInput = readInput("Day01Test")
    val input = readInput("Day01")
    val inp = input.map { it.toInt() }


    fun part1(): Int {
        val h = HashSet<Int>(inp.size)
        inp.forEach {
            if (h.contains(2020 - it)) {
                return it * (2020 - it)
            } else {
                h.add(it)
            }
        }
        return -1
    }

    fun part2(): Int {
        val h = HashSet<Int>(inp.size)
        for(i in inp.indices-1){
            for(j in i+1 until inp.size){
                if (h.contains(2020-inp[i]-inp[j])){
                    return (inp[i]*inp[j]*(2020-inp[i]-inp[j]))
                }
                h.add(inp[j])
            }
            h.add(inp[i])
        }
        return -1
    }

    println(part1())
    println(part2())

}
