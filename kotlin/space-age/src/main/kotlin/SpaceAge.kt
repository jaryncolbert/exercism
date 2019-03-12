import java.text.DecimalFormat

class SpaceAge(age: Long) {

    constructor(age: Int) : this(age.toLong())

    private val earthYears = age / 31557600.0

    fun onEarth(): Double { return twoDecimals(earthYears) }

    fun onMercury(): Double { return twoDecimals(earthYears / 0.2408467) }

    fun onVenus(): Double { return twoDecimals(earthYears / 0.61519726) }

    fun onMars(): Double { return twoDecimals(earthYears / 1.8808158) }

    fun onJupiter(): Double { return twoDecimals(earthYears / 11.862615) }

    fun onSaturn(): Double { return twoDecimals(earthYears / 29.447498) }

    fun onUranus(): Double { return twoDecimals(earthYears / 84.016846) }

    fun onNeptune(): Double { return twoDecimals(earthYears / 164.7913) }
    
    private fun twoDecimals(number: Double): Double {
        val format = DecimalFormat("#.##")
        return format.format(number).toDouble()
    }

}