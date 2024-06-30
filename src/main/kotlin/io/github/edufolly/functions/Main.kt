package io.github.edufolly.functions

fun main() {
    // Positional arguments.
    val gray = Kolor(127, 127, 127)

    // Named arguments.
    val white = Kolor(blue = 255, green = 255, red = 255)

    // Default arguments.
    val black = Kolor()

    // Using infix function.
    // Interpolate 5 steps between white and black.
    val kolorList = white..black interpolate 5

    println(kolorList.size) // 7

    // Equals operator.
    println(gray == kolorList[3]) // true
}

/**
 * Kolor class.
 */
data class Kolor(
    val red: Int = 0,
    val green: Int = 0,
    val blue: Int = 0,
) {
    init {
        // Semantic validation.
        require(red in 0..255) { "red must be in 0..255" }
        require(green in 0..255) { "green must be in 0..255" }
        require(blue in 0..255) { "blue must be in 0..255" }
    }

    // Single-expression functions.

    operator fun rangeTo(other: Kolor): KolorRange = KolorRange(this, other)

    override fun toString(): String =
        "Kolor(red=$red, green=$green, blue=$blue)"
}

/**
 * Kolor range class.
 */
class KolorRange(
    private val start: Kolor,
    private val end: Kolor,
) {
    // Infix function.
    infix fun interpolate(steps: Int): List<Kolor> {
        require(steps > 0) { "steps must be greater than 0" }

        val newStep = (steps + 1).toDouble()

        val redStep = (end.red - start.red) / newStep
        val greenStep = (end.green - start.green) / newStep
        val blueStep = (end.blue - start.blue) / newStep

        return List(steps + 2) {
            Kolor(
                (start.red + redStep * it).toInt(),
                (start.green + greenStep * it).toInt(),
                (start.blue + blueStep * it).toInt(),
            )
        }
    }
}
