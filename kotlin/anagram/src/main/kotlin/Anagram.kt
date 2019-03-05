
class Anagram(input: String) {

    private val anagram = input.toLowerCase()
    private val charSet = normalize(anagram)

    fun match(candidates: List<String>): Set<String> {
        val anagrams = candidates.filter { it.toLowerCase() != anagram && charSet == normalize(it) }
        return anagrams.toSet()
    }

    private fun normalize(string: String): List<Char> {
        return string.toLowerCase().toCharArray().sorted()
    }

}