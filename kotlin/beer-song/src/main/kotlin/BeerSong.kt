class BeerSong {

    private abstract class Bar(var numBeers: Int,
                               val transitionMessage: String) {

        abstract fun bottles(): String
        abstract fun takeOne(): Bar

        fun singVerse(): String {
            return "${bottles().capitalize()} of beer on the wall, ${bottles()} of beer.\n" +
                    "$transitionMessage, ${takeOne().bottles()} of beer on the wall.\n"
        }

        companion object {

            fun withBeers(numBeers: Int): Bar {
                return when (numBeers) {
                    0 -> EmptyBar()
                    1 -> SingleBeerBar()
                    else -> DefaultBar(numBeers)
                }
            }
        }
    }

    private open class DefaultBar(numBeers: Int,
                                  transitionMessage: String = "Take one down and pass it around") :
            Bar(numBeers, transitionMessage) {

        override fun bottles(): String {
            return numBeers.toString() + " " + contents()
        }

        open fun contents(): String {
            return "bottles"
        }

        override fun takeOne(): Bar {
            return Bar.withBeers(numBeers - 1)
        }
    }

    private class SingleBeerBar : DefaultBar(1, "Take it down and pass it around") {
        override fun contents(): String {
            return "bottle"
        }
    }

    private class EmptyBar : DefaultBar(0, "Go to the store and buy some more") {
        override fun bottles(): String {
            return "no more bottles"
        }

        override fun takeOne(): Bar {
            return DefaultBar(99)
        }
    }


    companion object {

        fun verses(start: Int, stop: Int): String {
            require(stop <= start) { "Second value must be less than or equal to first value." }

            return (start.downTo(stop)).joinToString("\n") { Bar.withBeers(it).singVerse() }
        }

    }

}