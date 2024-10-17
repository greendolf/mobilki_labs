fun main() {

    println("Начало Main")

    imitationTwo()
    imitationOne()

    println("Конец Main")

    // все инструкции выполняются в одном потоке, по порядку
}

fun imitationOne() {
    for (i in 1..10) {
        Thread.sleep(300)
        println("One $i")
    }
}

fun imitationTwo() {
    for (i in 1..10) {
        Thread.sleep(300)
        println("Two $i")
    }
}