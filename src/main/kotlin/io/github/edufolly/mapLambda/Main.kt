package io.github.edufolly.mapLambda

fun main() {
    val map =
        mapOf<String, (String) -> String>(
            "Abacate" to { v -> "${v[0]}" },
            "Banana" to { v -> v.last().toString() },
            "Caju" to { v -> v.reversed() },
        )

    map.forEach { (k, v) -> println(v(k)) }
}
