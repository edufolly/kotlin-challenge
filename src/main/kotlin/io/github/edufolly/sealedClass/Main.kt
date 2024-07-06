package io.github.edufolly.sealedClass

fun main() {
    val shapes: List<Shape> =
        listOf(
            Circle(5.0),
            Square(5.0),
            Rectangle(5.0, 10.0),
        )

    shapes.forEach { shape ->
        println(
            "${shape::class.simpleName} => Area: ${shape.area}",
        )
    }
}

sealed class Shape {
    abstract val area: Double
}

data class Circle(
    val radius: Double,
) : Shape() {
    override val area: Double
        get() = Math.PI * radius * radius
}

data class Square(
    val side: Double,
) : Shape() {
    override val area: Double
        get() = side * side
}

data class Rectangle(
    val width: Double,
    val height: Double,
) : Shape() {
    override val area: Double
        get() = width * height
}
