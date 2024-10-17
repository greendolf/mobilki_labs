fun main() {
    println("Начало Main")
    Thread {
        imitationTwo()
        imitationOne()
    }.start()
    println("Конец Main")

    // два потока, в первом выполняется вывод на экран начало и конец main,
    // во втором синхронно выполняются функции
}