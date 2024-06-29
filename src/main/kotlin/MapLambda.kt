package io.github.edufolly

fun main() {
    val map =
        mapOf<String, (String) -> String>(
            "Abacate" to { v -> "${v[0]}" },
            "Banana" to { v -> v.last().toString() },
        )

    map.forEach { (k, v) -> println(v(k)) }
}
