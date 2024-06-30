package io.github.edufolly.multilineString

fun main() {
    // Yes, this is multiline.
    val string1 = "Abacate\nBanana\nCaju"
    println(string1)
    println("=".repeat(20))

    // Seriously? Yes.
    val string2 =
        "Abacate\n" +
            "Banana\n" +
            "Caju"
    println(string2)
    println("=".repeat(20))

    // Very ugly, but it works.
    val string3 = """Abacate
Banana
Caju"""
    println(string3)
    println("=".repeat(20))

    // Using trimIndent to remove the indentation.
    val string4 =
        """
        Abacate
        Banana
        Caju
        """.trimIndent()
    println(string4)
    println("=".repeat(20))

    // Attention: Look the first line indentation.
    val string5 =
        """
        Abacate
         Banana
          Caju
        """.trimIndent()
    println(string5)
    println("=".repeat(20))

    // Using trimMargin to remove the margin character.
    val string6 =
        """
        |Abacate
        |Banana
        |Caju
        """.trimMargin()
    println(string6)
    println("=".repeat(20))

    // String interpolation can be used in multiline strings.
    val abacate = "Abacate"
    val banana = "Banana"
    val caju = "Caju"

    val string7 =
        """
        |$abacate
        |$banana
        |$caju
        """.trimMargin()
    println(string7)
}
