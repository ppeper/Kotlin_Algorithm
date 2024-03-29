package programmers.level1

class Kth {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map {
            array.copyOfRange(it[0] - 1, it[1]).sorted()[it[2] - 1]
        }.toIntArray()
    }
}