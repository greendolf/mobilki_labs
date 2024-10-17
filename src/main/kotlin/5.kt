fun main() {
    val boat = Boat()
    val plane = Airplane()
    val tank = Tank()

    boat.start()
    boat.stop()

    plane.start()
    plane.stop()

    tank.start()
    tank.stop()
}

open class Vehicle1 {
    open val name: String = "Transport"
    open val speed: Int = 10
    open fun start() {
        println("transport поехал со скоростью 10")
    }

    open fun stop() {
        println("transport приехал со скоростью 10")
    }
}

class Boat : Vehicle1() {
    override val name: String = "Boat"
    override val speed: Int = 30

    override fun start() {
        println("Лодка $name поплыл со скоростью $speed")
    }

    override fun stop() {
        println("Лодка приплыл")
    }
}

class Airplane : Vehicle1() {
    override val name: String = "Boeing"
    override val speed: Int = 1000

    override fun start() {
        println("Airplane $name поплыл со скоростью $speed")
    }

    override fun stop() {
        println("Airplane приплыл")
    }
}

class Tank : Vehicle1() {
    override val name: String = "T-34"
    override val speed: Int = 80

    override fun start() {
        println("Tank $name поплыл со скоростью $speed")
    }

    override fun stop() {
        println("Tank t-34 приплыл")
    }
}