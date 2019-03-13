import kotlin.math.sign

class Squares(val n: Int) {

    fun squareOfSum(): Int {
        // Looked up - Formula for sum of integers 1..n
        val sumToN = (n * (n + 1)) / 2
        return sumToN * sumToN
    }

    fun sumOfSquares(): Int {
        // Looked up - Formula for sum of squares (extension of sum of integers above)
        return (n * (n + 1) * (2 * n + 1)) / 6
    }

    fun difference(): Int {
        return squareOfSum() - sumOfSquares()
    }
}