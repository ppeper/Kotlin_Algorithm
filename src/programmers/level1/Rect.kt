package programmers.level1

class Rect {
    fun solution(sizes: Array<IntArray>): Int {
        var width = 0
        var height = 0
        for (wallet in sizes) {
            wallet.sort()
            width = wallet[0].coerceAtLeast(width)
            height = wallet[1].coerceAtLeast(height)
        }
        return width * height
    }
}