import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    val square = Square1(3.0)
    println("square.perimeter() = ${square.perimeter()}")
    println("square.area() = ${square.area()}")

    val circle = Circle1(2.0)
    println("circle.perimeter() = ${circle.perimeter()}")
    println("circle.area() = ${circle.area()}")

    val triang = EquilateralTriangle1(2.0)
    println("triang.perimeter() = ${triang.perimeter()}")
    println("triang.area() = ${triang.area()}")
}

interface Figure1 {
    fun perimeter(): Double
    fun area(): Double
}

class Square1(private val side: Double) : Figure1 {
    override fun perimeter(): Double {
        return side * 4
    }

    override fun area(): Double {
        return side * side
    }
}

class Circle1(private val radius: Double) : Figure1 {
    override fun perimeter(): Double {
        return 2 * PI * radius
    }

    override fun area(): Double {
        return PI * radius * radius
    }
}

class EquilateralTriangle1(private val side: Double) : Figure1 {
    override fun perimeter(): Double {
        return side * 3
    }

    override fun area(): Double {
        return side * side * sqrt(3.0) / 4
    }
}