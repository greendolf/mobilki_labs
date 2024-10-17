fun main(args: Array<String>) {
    var input = -1
    var count = 0
    var sum = 0
    var avg = 0
    do {
        input = readln().toInt()
        count++
        sum += input
    } while (input != 0)
    count--
    avg = sum / count
    println("Количество: $count\nСумма: $sum\nСреднее арифметическое: $avg")
}