package io.github.edufolly.functions

fun main() {
    // Positional arguments
    val gray = Kolor(128, 128, 128)

    // Named arguments
    val white = Kolor(blue = 255, green = 255, red = 255)

    // Default arguments
    val black = Kolor()
}

/**
 * Kolor class.
 */
data class Kolor(
    val red: Int = 0,
    val green: Int = 0,
    val blue: Int = 0,
) {
    // Validate at construction time
    init {
        require(red in 0..255) { "red must be in 0..255" }
        require(green in 0..255) { "green must be in 0..255" }
        require(blue in 0..255) { "blue must be in 0..255" }
    }

    // Single-expression functions

    operator fun rangeTo(other: Kolor): KolorRange = KolorRange(this, other)

    override fun toString(): String =
        "Kolor(red=$red, green=$green, blue=$blue)"
}

/**
 * Kolor range class.
 */
class KolorRange(
    val start: Kolor,
    val end: Kolor,
)
