fun main() {
    var fahrenheit = { temp: Int -> (temp * 9 / 5) + 32 }
    println(fahrenheit(0))
    println(fahrenheit(5))
    println(fahrenheit(10))
}