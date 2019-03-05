class BeerSong {

    companion object {

        fun verses(start: Int, stop: Int): String {
            require(stop <= start) { "Second value must be less than or equal to first value." }

            return (start.downTo(stop)).joinToString("\n") {verse(it) }
        }

        private fun verse(round: Int): String {
            val transitionMsg = when (round) {
                0 -> "Go to the store and buy some more"
                1 -> "Take it down and pass it around"
                else -> "Take one down and pass it around"
            }
            val bottles = getBottleRef(round)

            return "${bottles.capitalize()} of beer on the wall, $bottles of beer.\n" +
                    "$transitionMsg, ${getBottleRef(round - 1)} of beer on the wall.\n"
        }

        private fun getBottleRef(round: Int): String {
            return when (round) {
                -1 -> "99"
                0 -> "no more"
                else -> round.toString()
            } + " " + pluralizeBottles(round)
        }

        private fun pluralizeBottles(round: Int): String {
            return if (round == 1) "bottle" else "bottles"
        }
    }

}