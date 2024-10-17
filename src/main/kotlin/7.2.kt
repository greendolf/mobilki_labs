class Point(var x: Int, var y: Int) {
    override fun toString(): String {
        return "текущие координаты: $x и $y"
    }
}

enum class Command {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

class Turtle {
    fun move(obj: Point, command: Command) {
        when (command) {
            Command.UP -> {
                obj.y += 1
                println("Произведено перемещение по оси Y на +1")
            }

            Command.DOWN -> {
                obj.y -= 1
                println("Произведено перемещение по оси Y на -1")
            }

            Command.LEFT -> {
                obj.x -= 1
                println("Произведено перемещение по оси X на -1")
            }

            Command.RIGHT -> {
                obj.x += 1
                println("Произведено перемещение по оси X на +1")
            }
        }
    }
}

fun main() {
    val point = Point(14, 88)
    println(point)

    val turtle = Turtle()

    turtle.move(point, Command.UP)
    println(point)

    turtle.move(point, Command.RIGHT)
    println(point)

    turtle.move(point, Command.DOWN)
    println(point)

    turtle.move(point, Command.LEFT)
    println(point)
}