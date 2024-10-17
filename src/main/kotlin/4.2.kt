class Arr2(var numbers: Array<Int>) {
    var sum: Int = numbers.sum()

    fun mult(): Array<Int> {
        var res = numbers.copyOf()
        for (i in res.indices) {
            res[i] = if (res[i] % 2 == 0) res[i] * 2 else res[i] * 3
        }
        return res
    }

    fun min(): Int {
        var res = numbers[0]
        numbers.forEach { item -> if (item < res) res = item }
        return res
    }

    fun max(): Int {
        var res = numbers[0]
        numbers.forEach { item -> if (item > res) res = item }
        return res
    }
}

fun main() {
    val array1 = arrayOf(1, 2, 3, 4, 5)
    val arr1 = Arr2(array1)
    val array2 = arr1.mult()
    print("Начальный массив: ")
    for (i in array1.indices) {
        print("${array1[i]} ")
    }
    println()
    print("Модифицированный массив: ")
    for (i in array2.indices) {
        print("${array2[i]} ")
    }
    println()
    println("Минимум: ${arr1.min()}, Максимум: ${arr1.max()}")
}