fun main() {
    println("Начало Main")

    Thread {
        imitationTwo()
    }.start()

    Thread {
        imitationOne1()
    }.start()

    println("Конец Main")

    // у каждой функции есть собственный поток, все выполняются асинхронно, одновременно
}

fun imitationOne1() {
    for (i in 1..10) {
        Thread.sleep(1500)
        println("One $i")
    }
}