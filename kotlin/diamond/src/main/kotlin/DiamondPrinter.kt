class DiamondPrinter {


    fun printToList(targetChar: Char): List<String> {
        val targetIndex = ('A'..'Z').indexOf(targetChar)

        val top = ('A'..targetChar).mapIndexed { currIndex, c ->
            val outerSpaces = " ".repeat(targetIndex - currIndex)

            if (currIndex == 0) {
                outerSpaces + c + outerSpaces
            } else {
                val innerSpaces = " ".repeat(currIndex * 2 - 1)
                outerSpaces + c + innerSpaces + c + outerSpaces
            }
        }

        val bottom = top.dropLast(1).reversed()

        return top + bottom

    }


}



