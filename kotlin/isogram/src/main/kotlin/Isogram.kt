class Isogram {

    companion object {

        fun isIsogram(input: String): Boolean {
            val filteredInput = input.replace("[-\\s]".toRegex(), "")

            val uniqueChars = filteredInput.toLowerCase().split("")
                .filter { it.isNotEmpty() }
                .distinct()

            return filteredInput.length == uniqueChars.count()
        }
    }
}