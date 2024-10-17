fun main() {
    val ufo = Ufo(0, 0)
    messageParse(
        "asDWdASw",
        { step: Int -> ufo.move(Command1.Up(step)) },
        { step: Int -> ufo.move(Command1.Down(step)) },
        { step: Int -> ufo.move(Command1.Left(step)) },
        { step: Int -> ufo.move(Command1.Right(step)) })
}

fun messageParse(
    encryptedMessage: String,
    eventUp: (Int) -> Unit,
    eventDown: (Int) -> Unit,
    eventLeft: (Int) -> Unit,
    eventRight: (Int) -> Unit
) {
    for (char in encryptedMessage) {
        when (char) {
            'a' -> eventLeft(1)
            'A' -> eventLeft(2)
            'd' -> eventRight(1)
            'D' -> eventRight(2)
            'w' -> eventUp(1)
            'W' -> eventUp(2)
            's' -> eventDown(1)
            'S' -> eventDown(2)
        }
    }
}

sealed class Command1 {
    data class Up(var step: Int) : Command1()
    data class Down(var step: Int) : Command1()
    data class Right(var step: Int) : Command1()
    data class Left(var step: Int) : Command1()
}


class Ufo(var x: Int, var y: Int) {
    override fun toString(): String {
        return "текущие координаты (${x}, ${y})"
    }

    fun move(command: Command1) {
        when (command) {
            is Command1.Up -> {
                y += command.step
                println("Тарелка Рика сместилась вверх на ${command.step}")
            }

            is Command1.Down -> {
                y -= command.step
                println("Тарелка Рика сместилась вниз на ${command.step}")
            }

            is Command1.Right -> {
                x += command.step
                println("Тарелка Рика сместилась вправо на ${command.step}")
            }

            is Command1.Left -> {
                x -= command.step
                println("Тарелка Рика сместилась влево на ${command.step}")
            }
        }
        println(toString())
    }
}