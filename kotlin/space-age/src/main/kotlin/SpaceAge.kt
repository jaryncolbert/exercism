import java.math.RoundingMode

class SpaceAge(age: Long) {

    constructor(age: Int) : this(age.toLong())

    private val earthYears = age / 31557600.0

    private enum class Planet(val year: Double) {
        EARTH(1.0),
        MERCURY(0.2408467),
        VENUS(0.61519726),
        MARS(1.8808158),
        JUPITER(11.862615),
        SATURN(29.447498),
        URANUS(84.016846),
        NEPTUNE(164.7913)
    }

    fun onEarth(): Double { return getYearOn(Planet.EARTH) }

    fun onMercury(): Double { return getYearOn(Planet.MERCURY) }

    fun onVenus(): Double { return getYearOn(Planet.VENUS) }

    fun onMars(): Double { return getYearOn(Planet.MARS) }

    fun onJupiter(): Double { return getYearOn(Planet.JUPITER) }

    fun onSaturn(): Double { return getYearOn(Planet.SATURN) }

    fun onUranus(): Double { return getYearOn(Planet.URANUS) }

    fun onNeptune(): Double { return getYearOn(Planet.NEPTUNE) }
    
    private fun getYearOn(planet: Planet): Double {
        return (earthYears / planet.year).toBigDecimal()
                .setScale(2, RoundingMode.HALF_UP)
                .toDouble()
    }

}