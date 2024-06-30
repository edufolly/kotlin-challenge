@file:Suppress("EmptyRange")

package io.github.edufolly.rangeTo

fun main() {
    println(0..5) // 0..5

    println((0..5).javaClass) // class kotlin.ranges.IntRange

    println((0..5).toSet()) // [0, 1, 2, 3, 4, 5]

    println((0..5 step 2).toList()) // [0, 2, 4]

    println(0..<5) // 0..4

    println((0..5).sum()) // 15

    println(5..0) // 5..0

    println(5 downTo 0) // 5 downTo 0

    println((5 downTo 0).toSet()) // [5, 4, 3, 2, 1, 0]

    println((5 downTo 0 step 2).toList()) // [5, 3, 1]

    println(5.downTo(0).joinToString(", ")) // 5, 4, 3, 2, 1, 0

    println(5.downTo(0).joinToString(", ", limit = 3)) // 5, 4, 3, ...
}
