class Acronym {

    companion object {

        fun generate(phrase: String): String {

            // Split on non-word characters then grab first char of each word
            return phrase.split("\\W+".toRegex()).map { it[0] }
                    .joinToString("").toUpperCase()

        }

    }

}