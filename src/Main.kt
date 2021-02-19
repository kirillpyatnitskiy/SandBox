import classes.CompareVersion
import classes.Hello
import classes.MutableListTest
import classes.TestStaticFun
import java.util.*


fun main(args: Array<String>) {

    println(convert(20.0) { it * 1.8 + 32 })
    convertIntToDouble(5) { it.toDouble() + 200.0 }
    println(returnLambda("CentigradeToFahrenheit")(20.2))
    createStoredSet()
    Hello.tstJ()
    TestStaticFun.tst()
    arrayConcatenation()
    testMap()
    testMapOf()
    testMapForeach()
    TestSetValueInVar()
    println(testGeneric<Int>()::class.java)
    testTo()
    makeMaskForText()
    compareVersion()
    testWhen()
    MutableListTest().concatenationLists()
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

    val point = when (n) {
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
    val map : Map<String,String?> = mapOf("first" to "Один", "second" to "Два", "third" to null)
    println(map.getValue("first"))
    println(map.size)
    println()
}

fun testMapForeach(){
    val map : Map<String,String> = mapOf("first" to "Один", "second" to "Два")
    map.forEach{
        println(it.key)
    }
    println()
}

fun <T> testGeneric() : T {
    val any = 123
    return any as T
}

fun testTo(){
    val str = "123"
    val result : Pair<String, String> = str to "4"
    println(result)
    println()
}

fun makeMaskForText(){
    val text = "Testtext"
    val maskedText = text.substring(0, 4) + " " + text.substring(4)
    println(maskedText)
    println()

    val phone = "+7 (903) 238-92-45"
    val formattedPhone = phone.let {
        return@let it.removeRange(0,4).removeRange(3,5).replace("-", "")
    }
    println(formattedPhone)
    println()
}

fun compareVersion(){
    println("Compare version ${CompareVersion().compareVersion("1.5.6", "1.5.4").toString()}")
    println()
}

class ElementForSS(str: String) {
    val id = (0..100).shuffled().first()
    val elementValue = str
}

class TestSetValueInVar{
    var variable : String = "first value"
    set(value){
        setTestVariable(value)
//        field = value         //если мы хотим поменять значение variable, то нужно использовать ключевое слоо field
    }

    init{
        variable = "second value"
        printCurentValue()
        println()
    }

    fun setTestVariable(value: String){
        println("We set value: $value")
    }

    fun printCurentValue(){
        println("Variable have value: $variable")
    }
}

