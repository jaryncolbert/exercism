class Bob {

    companion object {

        fun hey(input: String): String {
            val trimmed = input.trim()
            val filtered = trimmed.filter { it.isLetter() }
            val isYelled = filtered.isNotEmpty() && filtered.all { it.isUpperCase() }
            val isQuestion = trimmed.endsWith('?')

            return when {
                isYelled && isQuestion -> "Calm down, I know what I'm doing!"
                isYelled -> "Whoa, chill out!"
                isQuestion -> "Sure."
                trimmed.isEmpty() -> "Fine. Be that way!"
                else -> "Whatever."
            }

        }

    }
}