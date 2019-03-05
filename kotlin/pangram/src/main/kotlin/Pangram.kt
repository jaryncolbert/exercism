

class Pangram {

    companion object {
        fun isPangram(pangram: String): Boolean {
            val alphabet = "abcdefghijklmnopqrstuvwxyz"
            val lowerPangram = pangram.toLowerCase()

            for (letter in alphabet.split("")) {
                if (!lowerPangram.contains(letter))
                    return false
            }

            return true
        }

    }
}