fun main() {
    fun part1(input: List<String>): Int {
        return input.withIndex().count { (index, value) -> index > 0 && value.toInt() > input[index - 1].toInt() }
    }

    fun part2(input: List<String>): Int {
        return input.subList(0, input.size - 2)
            .mapIndexed { index, value -> value.toInt() + input[index+1].toInt() + input[index+2].toInt() }
            .withIndex()
            .zipWithNext { first, second -> first.value < second.value }
            .count { it }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
