package programmers.level1

//2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT
//
//입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
//
//제한 조건
//2016년은 윤년입니다.
//2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)

class Year {
    fun solution(a: Int, b: Int): String {
        val dayString = listOf("THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED")
        val days = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        var sum = 0
        for (i in 0 until a - 1) {
            sum += days[i]
        }
        return dayString[(sum + b) % 7]
    }
}