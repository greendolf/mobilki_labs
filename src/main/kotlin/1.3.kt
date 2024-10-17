fun main(args: Array<String>) {
    val a = (0..10).random()
    while (true) {
        print("Введите число: ")
        val b = readln().toInt()
        val des = if (b > a) {
            println("Много")
        } else if (b < a) {
            println("Мало")
        } else {
            println("Угадал")
            break
        }
    }
}