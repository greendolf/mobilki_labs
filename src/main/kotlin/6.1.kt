import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    val square = Square(2.0)
    println("square.perimeter() = ${square.perimeter()}")
    println("square.area() = ${square.area()}")

    val circle = Circle(2.0)
    println("circle.perimeter() = ${circle.perimeter()}")
    println("circle.area() = ${circle.area()}")

    val triang = EquilateralTriangle(2.0)
    println("triang.perimeter() = ${triang.perimeter()}")
    println("triang.area() = ${triang.area()}")
}

abstract class Figure {
    abstract fun perimeter(): Double
    abstract fun area(): Double
}

class Square(private val side: Double) : Figure() {
    override fun perimeter(): Double {
        return side * 4
    }

    override fun area(): Double {
        return side * side
    }
}

class Circle(private val radius: Double) : Figure() {
    override fun perimeter(): Double {
        return 2 * PI * radius
    }

    override fun area(): Double {
        return PI * radius * radius
    }
}

class EquilateralTriangle(private val side: Double) : Figure() {
    override fun perimeter(): Double {
        return side * 3
    }

    override fun area(): Double {
        return side * side * sqrt(3.0) / 4
    }
}