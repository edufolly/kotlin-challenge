package io.github.edufolly.operators

fun main() {
    val red = Kolor(255, 0, 0)
    val green = Kolor(0, 255, 0)
    val blue = Kolor(0, 0, 255)

    val yellow = red + green

    println(yellow) // Kolor(red=255, green=255, blue=0)

    println(yellow - red) // Kolor(red=0, green=255, blue=0)

    val nullKolor: Kolor? = null

    println(red + nullKolor) // Kolor(red=255, green=0, blue=0)

    val mutableBlue: MutableKolor = blue.toMutableKolor()

    // First operand defines the result type.
    println(mutableBlue + red) // MutableKolor(red=255, green=0, blue=255)
    println(red + mutableBlue) // Kolor(red=255, green=0, blue=255)

    try {
        // Must throw an exception
        mutableBlue - red
    } catch (e: IllegalArgumentException) {
        println(e.message) // Red must be between 0 and 255: -255
    }

    // Transform blue to magenta.
    mutableBlue += red

    println(mutableBlue) // MutableKolor(red=255, green=0, blue=255)

    // Back to blue.
    mutableBlue -= red

    println(mutableBlue) // MutableKolor(red=0, green=0, blue=255)
}

/**
 * Interface for kolor classes.
 */
interface Kolorable<T> {
    val red: Int
    val green: Int
    val blue: Int

    fun create(
        red: Int,
        green: Int,
        blue: Int,
    ): T
}

/**
 * Abstract class for kolor classes.
 */
abstract class AbstractKolor<T : Kolorable<T>>(
    override val red: Int = 0,
    override val green: Int = 0,
    override val blue: Int = 0,
) : Kolorable<T> {
    // TODO: Could be better?
    fun validate(newKolor: T): T {
        require(newKolor.red in 0..255) {
            "Red must be between 0 and 255: ${newKolor.red}"
        }
        require(newKolor.green in 0..255) {
            "Green must be between 0 and 255: ${newKolor.green}"
        }
        require(newKolor.blue in 0..255) {
            "Blue must be between 0 and 255: ${newKolor.blue}"
        }

        return newKolor
    }

    operator fun plus(other: Kolorable<*>?): T =
        validate(
            create(
                red + (other?.red ?: 0),
                green + (other?.green ?: 0),
                blue + (other?.blue ?: 0),
            ),
        )

    operator fun minus(other: Kolorable<*>?): T =
        validate(
            create(
                red - (other?.red ?: 0),
                green - (other?.green ?: 0),
                blue - (other?.blue ?: 0),
            ),
        )

    override fun toString(): String =
        "${this.javaClass.simpleName}(red=$red, green=$green, blue=$blue)"
}

/**
 * Kolor class.
 */
data class Kolor(
    override val red: Int,
    override val green: Int,
    override val blue: Int,
) : AbstractKolor<Kolor>() {
    override fun create(
        red: Int,
        green: Int,
        blue: Int,
    ): Kolor = Kolor(red, green, blue)

    fun toMutableKolor(): MutableKolor = MutableKolor(red, green, blue)
}

/**
 * Mutable kolor class.
 */
class MutableKolor(
    override var red: Int,
    override var green: Int,
    override var blue: Int,
) : AbstractKolor<MutableKolor>() {
    override fun create(
        red: Int,
        green: Int,
        blue: Int,
    ): MutableKolor = MutableKolor(red, green, blue)

    fun toKolor(): Kolor = Kolor(red, green, blue)

    operator fun plusAssign(other: Kolor) {
        red += other.red
        green += other.green
        blue += other.blue
        validate(this)
    }

    operator fun minusAssign(other: Kolor) {
        red -= other.red
        green -= other.green
        blue -= other.blue
        validate(this)
    }
}
