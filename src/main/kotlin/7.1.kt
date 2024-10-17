class Car(var name: String, var speed: Int)

data class Vehicle(var name: String, var speed: Int)

fun main() {
    val car1 = Car("Lada", 100)
    val car2 = Car("Lada", 100)

    println("Сравнение car1 и car2:\n(==): ${car1 == car2}\n(===): ${car1 === car2}")
    println("Хэш:\ncar1: ${car1.hashCode()}\ncar2: ${car2.hashCode()}")

    val car3 = car1
    println("Сравнение car1 и car3:\n(==): ${car1 == car3}\n(===): ${car1 === car3}")
    println("Хэш:\ncar1: ${car1.hashCode()}\ncar3: ${car3.hashCode()}")
    // ъэши одинаковые
    car3.name = "Belaz"
    println("Car1 name: ${car1.name}\nCar3 name: ${car3.name}")
    // изменения отразились на обоих объектах, значит
    // переменные представляют собой ссылку на одну и ту же область памяти

    val vehicle1 = Vehicle("Ural", 100)
    val vehicle2 = Vehicle("Ural", 100)

    println("Сравнение vehicle1 и vehicle2:\n(==): ${vehicle1 == vehicle2}\n(===): ${vehicle1 === vehicle2}")
    println("Хэш:\nvehicle1: ${vehicle1.hashCode()}\nvehicle2: ${vehicle2.hashCode()}")
    
    val vehicle3 = vehicle1.copy("Zil")
    val vehicle4 = vehicle1.copy()

    println("Сравнение vehicle1 и vehicle3:\n(==): ${vehicle1 == vehicle3}\n(===): ${vehicle1 === vehicle3}")
    println("Хэш:\nvehicle1: ${vehicle1.hashCode()}\nvehicle3: ${vehicle3.hashCode()}")

    println("Сравнение vehicle1 и vehicle3:\n(==): ${vehicle1 == vehicle4}\n(===): ${vehicle1 === vehicle4}")
    println("Хэш:\nvehicle1: ${vehicle1.hashCode()}\nvehicle4: ${vehicle4.hashCode()}")

    // при == сравнении дата объекты сравниваются по значениям полей
    // при === сравнении дата объекты сравниваются по адресу памяти

}