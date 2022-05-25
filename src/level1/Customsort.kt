package level1

class Customsort {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        strings.sortWith(
            compareBy<String> {
                it[n]
            }.thenBy { it }
        )
        return strings
    }
}