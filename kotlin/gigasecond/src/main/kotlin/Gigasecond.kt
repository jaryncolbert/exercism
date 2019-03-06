import java.time.LocalDate

class Gigasecond(birthDate: LocalDate) {

    val date: LocalDate

    init {
        val gigasecond = 1000000000.toDouble()
        val days = gigasecond / 60 / 60 / 24

        date = birthDate.plusDays(days.toLong())
    }
}