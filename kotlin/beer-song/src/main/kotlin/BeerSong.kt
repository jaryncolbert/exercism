class BeerSong {

    private open class Bar(var numBeers: Int,
                           val transitionMessage: String = "Take one down and pass it around") {

        open fun bottles(): String {
            return numBeers.toString() + " " + contents()
        }

        open fun contents(): String {
            return "bottles"
        }

        open fun takeOne(): Bar {
            if (numBeers == 2) {
                return SingleBeerBar()
            } else {
                numBeers -= 1
                return this
            }
        }
    }

    private class EmptyBar : Bar(0, "Go to the store and buy some more") {
        override fun bottles(): String {
            return "no more"
        }

        override fun takeOne(): Bar {
            return restock()
        }

        fun restock(): Bar {
            return Bar(99)
        }
    }

    private class SingleBeerBar : Bar(1, "Take it down and pass it around") {
        override fun contents(): String {
            return "bottle"
        }

        override fun takeOne(): Bar {
            return EmptyBar()
        }
    }


    companion object {

        fun verses(start: Int, stop: Int): String {
            require(stop <= start) { "Second value must be less than or equal to first value." }

            return (start.downTo(stop)).joinToString("\n") {verse(it) }
        }

        private fun verse(numBeers: Int): String {
            val bar = Bar(numBeers)
            val bottles = bar.bottles()

            return "${bottles.capitalize()} of beer on the wall, $bottles of beer.\n" +
                    "${bar.transitionMessage}, ${bar.takeOne().bottles()} of beer on the wall.\n"
        }

    }

}