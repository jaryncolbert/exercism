class Hamming {

    companion object {
        fun compute(left: String, right: String): Int {
            require(left.length == right.length) { "left and right strands must be of equal length." }

            val diff = left.filterIndexed { index, c ->
                c != right[index]
            }

            return diff.length
        }
    }
}