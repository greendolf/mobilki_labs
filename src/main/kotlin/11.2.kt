fun main() {
    val concat = { a: String, b: String, c: String ->
        var res = ""
        val an = a.length
        val bn = b.length
        val cn = c.length
        if (an < bn && an < cn) {
            res += a
            if (bn < cn) {
                res += b
                res += c
            } else {
                res += c
                res += b
            }
        } else if (bn < an && bn < cn) {
            res += b
            if (an < cn) {
                res += a
                res += c
            } else {
                res += c
                res += a
            }
        } else {
            res += c
            if (an < bn) {
                res += a
                res += b
            } else {
                res += b
                res += a
            }
        }
        res
    }
    println(concat("россия", "рай", "америка"))
//    val concat = { params: Array<String> ->
//        val sortedParams = params.sortedArray().joinToString(", ")
//        println(sortedParams)
//    }
//    concat(arrayOf("россия", "раааай", "сша", "аад"))
}