import kotlin.math.sqrt

class Vector(var x: Int, var y: Int, var z: Int) {
    fun length(): Double {
        return sqrt((x * x + y * y + z * z).toDouble())
    }

    fun scalarMult(other: Vector): Int {
        return x * other.x + y * other.y + z * other.z
    }

    operator fun times(multiplier: Vector): Int {
        return x * multiplier.x + y * multiplier.y + z * multiplier.z
    }

    infix fun scalar(other: Vector): Int {
        return x * other.x + y * other.y + z * other.z
    }

}

fun scalarMult(left: Vector, right: Vector): Int {
    return left.x * right.x + left.y * right.y + left.z * right.z
}

fun main() {
    var v1 = Vector(1, 2, 3)
    var v2 = Vector(4, 5, 6)
    println("Длины векторов: ${v1.length()} и ${v2.length()}")
    println("Умножение векторов:")
    println("Обычный метод: ${v1.scalarMult(v2)}")
    println("Инфиксный метод: ${v1 scalar v2}")
    println("Переопределение оператора: ${v1 * v2}")
    println("Внешняя функция: ${scalarMult(v1, v2)}")
}