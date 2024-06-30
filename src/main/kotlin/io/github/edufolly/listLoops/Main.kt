@file:Suppress(
    "ReplaceRangeToWithRangeUntil",
    "ReplaceManualRangeWithIndicesCalls",
)

package io.github.edufolly.listLoops

fun main() {
    val myList = listOf("A", "B", "C", "D", "E", "F")

    for (index in 0..myList.size - 1) {
        val item = myList[index]
        println("$index: $item")
    }

    for (index in 0..<myList.size) {
        val item = myList[index]
        println("$index: $item")
    }

    for (index in myList.indices) {
        val item = myList[index]
        println("$index: $item")
    }

    for (index in myList.indices) {
        println("$index: ${myList[index]}")
    }

    for ((index, item) in myList.withIndex()) {
        println("$index: $item")
    }

    myList.withIndex().forEach { (index, item) ->
        println("$index: $item")
    }
}
