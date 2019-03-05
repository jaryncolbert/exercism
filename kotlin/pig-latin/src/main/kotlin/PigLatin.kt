class PigLatin {

    companion object {

        fun translate(input: String): String {

            val words = input.trim().split("\\s+".toRegex()).filter { it.isNotEmpty() }
            val result = mutableListOf<String>()

            for (word in words) {
                result.add(translateWord(word))
            }

            return result.joinToString(" " )
        }

        private fun translateWord(input: String): String {
            val vowels = listOf("a", "e", "i", "o", "u")
            val vowelSounds = vowels + "xr" + "yt"

            // Add "ay" to the end of words beginning with vowel sounds
            val str = input.toLowerCase()
            for (vowelSound in vowelSounds) {
                if (str.startsWith(vowelSound))
                    return input + "ay"
            }

            // Find first index of a vowel (after first character to account for leading 'y')
            val vowelIndex = str.substring(1)
                    .indexOfFirst { it.toString() in (vowels + "y") } + 1

            // Account for 'qu'
            val splitIndex = if (str[vowelIndex] == 'u' && str[vowelIndex - 1] == 'q') {
                vowelIndex + 1
            } else {
                vowelIndex
            }

            // Separate string into tail, head, then 'ay'
            val head = str.substring(0, splitIndex)
            val tail = str.substring(splitIndex)
            return tail + head + "ay"
        }
    }
}