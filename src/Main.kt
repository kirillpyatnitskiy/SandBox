import java.sql.DriverManager
import java.util.*


fun main(args: Array<String>) {


    println(convert(20.0) { it * 1.8 + 32 })
    convertIntToDouble(5) { it.toDouble() + 200.0 }
    println(returnLambda("CentigradeToFahrenheit")(20.2))
    createStoredSet()
    Hello.tstJ()
    TestStaticFun.tst()
    arrayConcatenation()
    testWhen()
    testMap()
    testMapOf()


}

fun convert(x: Double, converter: (Double) -> Double): Double {
    return converter(x)
}

fun convertIntToDouble(x: Int, converter: (Int) -> Double): Double {
    val result = converter(x)
    println(result)
    return result
}

fun returnLambda(str: String): (Double) -> Double {
    if (str == "CentigradeToFahrenheit") {
        return { it * 1.8 + 32 }
    } else if (str == "KgsToPounds") {
        return { it * 2.204623 }
    } else if (str == "PoundsToUSTons") {
        return { it / 2000.0 }
    } else {
        return { it }
    }
}

fun createStoredSet() {
    val comporator = java.util.Comparator<ElementForSS> { o1, o2 ->
        if (o1.elementValue.startsWith("A") || !o2.elementValue.startsWith("A")) {
            1
        } else {
            o1.id.compareTo(o2.id)
        }
    }
    val ss: SortedSet<ElementForSS> = TreeSet<ElementForSS>(comporator)
    ss.addAll(listOf<ElementForSS>(ElementForSS("A"), ElementForSS("a"), ElementForSS("s"), ElementForSS("S"), ElementForSS("London"), ElementForSS("Africa"), ElementForSS("Russia")))
    ss.forEach { print("${it.elementValue} id=${it.id} | ") }
    println()
}

fun arrayConcatenation() {
    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(list.joinToString())
    println(list.joinToString("-", "!", "?", -1))
    println (list.joinToString { "! $it ?" })
    println()
}

fun testWhen() {
    val n = 52
    val point: Int

    point = when (n) {
        in 0..30, in 71..100 -> 1
        in 31..47, in 53..70 -> 2
        48, 49, 50, 51, 52 -> 4
        else -> 0
    }

    println(point)
    println()
}

fun testMap(){
    val list: List<String> = listOf("y", "a", "b", "c", "d")
    println(list.map {it + "1"})
    println(list.javaClass)
    println(list.map {it + "1"}.javaClass)
    println()
}

fun testMapOf(){
    val map : Map<String,String> = mapOf("first" to "Один", "second" to "Два")
    val str = map.getValue("first")
    println(map.getValue("first"))
    println()
}


class ElementForSS(str: String) {
    val id = (0..100).shuffled().first()
    val elementValue = str
}
