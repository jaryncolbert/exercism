class BeerSong {

    companion object {

        fun verses(start: Int, stop: Int): String {
            require(stop <= start) { "Second value must be less than or equal to first value." }

            return (start.downTo(stop)).joinToString("\n") {verse(it) }
        }

        private fun verse(round: Int): String {
            val bottles = when (round) {
                0 -> "no more bottles"
                1 -> "1 bottle"
                else -> "$round bottles"
            }

            val nextBottles = when (round) {
                0 -> "99 bottles"
                1 -> "no more bottles"
                2 -> "1 bottle"
                else -> "${round - 1} bottles"
            }

            val transitionMsg = when (round) {
                0 -> "Go to the store and buy some more"
                1 -> "Take it down and pass it around"
                else -> "Take one down and pass it around"
            }


            return "${bottles.capitalize()} of beer on the wall, $bottles of beer.\n" +
                    "$transitionMsg, $nextBottles of beer on the wall.\n"
        }

    }
}