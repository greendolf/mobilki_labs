import kotlin.math.pow

fun main() {

    val numbers = listOf(-1, 0, 2, 3)

    // 1 все отрицательные
    var filteredList = numbers.filter { it < 0 }
    println(filteredList)
    println()

    // 2 сделать все отрицательными
    filteredList = numbers.map { if (it > 0) -it else it }
    println(filteredList)
    println()

    // 3 оквадратить
    filteredList = numbers.map { it * it }
    println(filteredList)
    println()

    // 4 сложить
    val nums = (1..7).toList()
    println(nums.joinToString("+", "=", "="))
    println()

    // 5 код страны
    val phoneBook = mapOf("Name1" to "+1-234", "Name2" to "+1-233", "Name3" to "+3-21", "Name11" to "+4-32")
    val countryCode = "+1"
    val filteredMap = phoneBook.filter { (key, value) -> value.startsWith(countryCode)}
    println(filteredMap)
    println()

    // 6 секунды с начала дня
    val time = "01:20:12"
    println(
        time
            .split(":")
            .map { it.toDouble() }
            .reduceRightIndexed { index, el, acc ->
                acc + el.toDouble() * 60.0.pow(2 - index)
            }
    )
}