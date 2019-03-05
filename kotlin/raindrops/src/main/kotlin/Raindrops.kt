class Raindrops {

    companion object {

        fun convert(input: Int): String {
            var result = ""

            val divBy3 = input.rem(3) == 0
            val divBy5 = input.rem(5) == 0
            val divBy7 = input.rem(7) == 0

            if (divBy3 || divBy5 || divBy7) {
                if (divBy3) {
                    result += "Pling"
                }

                if (divBy5) {
                    result += "Plang"
                }

                if (divBy7) {
                    result += "Plong"
                }
            } else {
                result = input.toString()
            }

            return result
        }
    }
}