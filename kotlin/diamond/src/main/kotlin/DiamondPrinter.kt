class DiamondPrinter {


    fun printToList(char: Char): List<String> {
        val alphabet = 'A'..'Z'
        val charIndex = alphabet.indexOf(char)

        return ('A'..char).mapIndexed { alphabetIndex, c ->
            val spaceCount = charIndex - alphabetIndex
            val outerSpaces = " ".repeat(spaceCount)

            if (alphabetIndex == 0) {
                outerSpaces + c + outerSpaces
            } else {
                val innerSpaces = " ".repeat(alphabetIndex * 2 - 1)
                outerSpaces + c + innerSpaces + c + outerSpaces
            }
        }

    }


}



