fun messageParse(message: String, eventX: () -> Unit, eventY: () -> Unit, eventZ: () -> Unit) {
    for (item in message) {
        when (item) {
            'x' -> eventX()
            'y' -> eventY()
            'z' -> eventZ()
        }
    }
}

fun main() {
    messageParse("abxbbznmfkYyyxX", { -> println("найден x") }, { -> println("найден y") }, { -> println("найден z") })
}