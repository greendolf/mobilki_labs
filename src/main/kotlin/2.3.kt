import kotlin.random.Random

fun main() {
    fun forTask(list: List<Int>) {
        var min = list[0]
        var max = list[0]
        var mult = 1
        for (item in list) {
            if (item < min) min = item
            else if (item > max) max = item
            mult *= item
        }
        println("for: $mult, $min, $max")
    }

    fun whileTask(list: List<Int>) {
        var min = list[0]
        var max = list[0]
        var mult = 1
        var i = 0
        while (i < list.size) {
            if (list[i] < min) min = list[i]
            else if (list[i] > max) max = list[i]
            mult *= list[i]
            i++
        }
        println("while: $mult, $min, $max")
    }

    fun reduceTask(list: List<Int>) {
        val mult = list.reduce { acc, i -> acc * i }
        val min = list.reduce { acc, i -> if (acc < i) acc else i }
        val max = list.reduce { acc, i -> if (acc > i) acc else i }
        println("reduce: $mult, $min, $max")
    }

    fun forEachTask(list: List<Int>) {
        var mult = 1
        var min = list[0]
        var max = list[1]
        list.forEach { item ->
            mult *= item
            if (item < min) min = item
            else if (item > max) max = item
        }
        println("forEach: $mult, $min, $max")
    }

    fun minMaxTask(list: List<Int>) {
        var min = list.min()
        var max = list.max()
        println("min max: null, $min, $max")
    }
    val ran = Random
    val list = (1..10).map { ran.nextInt() % 10 }
    println("Массив: $list")
    forTask(list)
    whileTask(list)
    reduceTask(list)
    forEachTask(list)
    minMaxTask(list)
}
