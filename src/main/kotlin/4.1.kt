class Arr(var numbers: Array<Int>) {
    fun sum(): Int {
        return numbers.reduce { acc, i -> acc + i }
    }
    fun mult(): Int {
        return numbers.reduce { acc, i -> acc * i }
    }
    fun avg(): Double {
        return this.sum().toDouble() / numbers.size
    }
}

fun main() {
    val arr1 = Arr(arrayOf(1, 2, 3, 4, 5))
    println("Сумма: ${arr1.sum()}, Произведение: ${arr1.mult()}, Среднее: ${arr1.avg()}")
}