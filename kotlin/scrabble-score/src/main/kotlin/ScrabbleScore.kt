object ScrabbleScore {

    private val rubric: Map<Char, Int>

    init {
        val one = listOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T') to 1
        val two = listOf('D', 'G') to 2
        val three = listOf('B', 'C', 'M', 'P') to 3
        val four = listOf('F', 'H', 'V', 'W', 'Y') to 4
        val five = listOf('K') to 5
        val eight = listOf('J', 'X') to 8
        val ten = listOf('Q', 'Z') to 10


        rubric = listOf(one, two, three, four, five, eight, ten).flatMap {
            val score = it.second
            it.first.map { c -> c to score }
        }.toMap()
    }

    fun scoreWord(input: String): Int {
        return input.toUpperCase().fold(0) { sum, c ->
            rubric[c]?.let { score -> sum + score } ?: 0
        }

    }
}