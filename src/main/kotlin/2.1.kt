fun main(args: Array<String>) {
    fun isSimple(x: Int): Boolean {
        for (i in 2..x/2) {
            if (x % i == 0) {
                return false
            }
        }
        return true
    }
    print("Введите количество простых чисел: ")
    var n = readln().toInt()
    var count = 0
    var x = 2
    while (count < n) {
        if (isSimple(x)) {
            println(x)
            count++
        }
        x++
    }
}

