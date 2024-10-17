fun main() {
    val num1 = readln().toDouble()
    val num2 = readln().toDouble()

    var res = 0.0

    when (readln()) {
        "+" -> res = num1 + num2
        "-" -> res = num1 - num2
        "*" -> res = num1 * num2
        "/" -> res = num1 / num2
    }

    println(res)
}