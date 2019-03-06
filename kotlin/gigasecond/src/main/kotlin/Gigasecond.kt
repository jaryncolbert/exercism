import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.time.temporal.Temporal

class Gigasecond(birthDate: Temporal) {

    val date: LocalDateTime

    init {

        val birthDateTime = when (birthDate) {
            is LocalDateTime -> birthDate
            is LocalDate -> birthDate.atStartOfDay()
            else -> throw IllegalArgumentException("Input must be LocalDate or LocalDateTime.")
        }

        date = birthDateTime.plus(1000000000.toLong(), ChronoUnit.SECONDS)

    }
}