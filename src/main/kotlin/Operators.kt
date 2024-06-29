package io.github.edufolly

fun main() {
    val red = Kolor(255, 0, 0)
    val green = Kolor(0, 255, 0)
    val blue = Kolor(0, 0, 255)

    val yellow = red + green

    println(yellow) // Kolor(red=255, green=255, blue=0)

    println(yellow - red) // Kolor(red=0, green=255, blue=0)

    val nullKolor: Kolor? = null

    println(red + nullKolor) // Kolor(red=255, green=0, blue=0)

    val mutableRed = red.toMutableKolor()

    println(mutableRed[KolorKomponent.RED]) // 255

    println(red to blue interpolate 0.5) // Kolor(red=127, green=0, blue=127)
}

data class Kolor(
    val red: Int,
    val green: Int,
    val blue: Int,
) {
    operator fun plus(other: Kolor?): Kolor {
        if (other == null) {
            return this
        }

        return Kolor(
            red + other.red,
            green + other.green,
            blue + other.blue,
        )
    }

    operator fun minus(other: Kolor?): Kolor {
        if (other == null) {
            return this
        }

        return Kolor(
            red - other.red,
            green - other.green,
            blue - other.blue,
        )
    }

    infix fun to(other: Kolor): ColorRange = ColorRange(this, other)

    fun toMutableKolor(): MutableKolor = MutableKolor(red, green, blue)
}

data class ColorRange(
    val start: Kolor,
    val end: Kolor,
) {
    infix fun interpolate(factor: Double): Kolor {
        val red = start.red + (end.red - start.red) * factor
        val green = start.green + (end.green - start.green) * factor
        val blue = start.blue + (end.blue - start.blue) * factor

        return Kolor(red.toInt(), green.toInt(), blue.toInt())
    }
}

enum class KolorKomponent {
    RED,
    GREEN,
    BLUE,
}

class MutableKolor(
    var red: Int,
    var green: Int,
    var blue: Int,
) {
    operator fun plus(other: Kolor?): MutableKolor {
        if (other == null) {
            return this
        }

        return MutableKolor(
            red + other.red,
            green + other.green,
            blue + other.blue,
        )
    }

    operator fun plusAssign(other: Kolor?) {
        if (other == null) {
            return
        }

        red += other.red
        green += other.green
        blue += other.blue
    }

    operator fun minus(other: Kolor?): MutableKolor {
        if (other == null) {
            return this
        }

        return MutableKolor(
            red - other.red,
            green - other.green,
            blue - other.blue,
        )
    }

    operator fun minusAssign(other: Kolor?) {
        if (other == null) {
            return
        }

        red -= other.red
        green -= other.green
        blue -= other.blue
    }

    operator fun get(component: KolorKomponent): Int =
        when (component) {
            KolorKomponent.RED -> red
            KolorKomponent.GREEN -> green
            KolorKomponent.BLUE -> blue
        }

    operator fun set(
        component: KolorKomponent,
        value: Int,
    ) {
        when (component) {
            KolorKomponent.RED -> red = value
            KolorKomponent.GREEN -> green = value
            KolorKomponent.BLUE -> blue = value
        }
    }

    override fun toString(): String = "($red, $green, $blue)"
}
