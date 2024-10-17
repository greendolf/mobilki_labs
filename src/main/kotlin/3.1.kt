import kotlin.math.sign
import kotlin.math.sqrt
import kotlin.random.Random

fun sqr(n: Double): Double {
    return n * n
}

fun discriminant(a: Double, b: Double, c: Double): Double {
    return sqr(b) - 4 * a * c
}

fun rootsNumber(a: Double, b: Double, c: Double): Int {
    val discr = discriminant(a, b, c)
    return when (sign(discr)) {
        -1.0 -> 0
        0.0 -> 1
        else -> 2
    }
    //return if (discr < 0) 0 else if (discr == 0.0) 1 else 2
}

fun quadraticRoot(a: Double, b: Double, c: Double) {
    when (val rootsNum = rootsNumber(a, b, c)) {
        0 -> println("Нет действительных корней")
        else -> {
            val discr = discriminant(a, b, c)
            println("Дискриминант: $discr")
            when (rootsNum) {
                1 -> {
                    println("Корень уравнения: ${b / 2 / a}")
                }
                else -> {
                    println("Корни уравнения: ${(b - sqrt(discr)) / 2 / a} и ${(b + sqrt(discr)) / 2 / a}")
                }
            }
        }
    }
}

fun main() {
    val ran = Random
    val list = listOf(1.0, 5.0, 3.0)
    println("Коэффициенты: $list")
    quadraticRoot(list[0], list[1], list[2])
}