import kotlin.random.Random

fun main(args: Array<String>) {
    fun forTask(arr: List<Int>) {
        print("(for) индексы: ")
        for (i in 1 until arr.lastIndex) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                print("$i : ${arr[i]}, \t")
            }
        }
        println()
    }

    fun whileTask(arr: List<Int>) {
        print("(while) индексы: ")
        var i = 1
        while (i < arr.lastIndex) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                print("$i : ${arr[i]}, \t")
            }
            i++
        }
        println()
    }

    fun forEachTask(arr: List<Int>) {
        print("(forEach) индексы: ")
        arr.forEachIndexed { index, i ->
            if (index > 0 && index < arr.lastIndex) {
                if (i > arr[index - 1] && i > arr[index + 1]) {
                    print("$index : $i, \t")
                }
            }
        }
        println()
    }

    var ran = Random
    var arr = (1..10).map { ran.nextInt() % 10 }
    println("Массив: $arr")
    forTask(arr)
    whileTask(arr)
    forEachTask(arr)
}

