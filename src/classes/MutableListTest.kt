package classes

class MutableListTest {

    fun concatenationLists(){
        val firstList: List<String> = listOf()
        val secondList: List<String> = listOf("один", "два", "три")
        val thirdList: List<String> = listOf("четыре", "пять")

        val resultList: MutableList<String> = mutableListOf()

        firstList.forEach { resultList.add(it) }
        secondList.forEach { resultList.add(it) }
        thirdList.forEach { resultList.add(it) }

        println(resultList.map { it })
        println()
    }
}