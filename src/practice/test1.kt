package practice

// 문제 설명
//길이가 n인 배열에 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는지를 확인하려고 합니다.
//1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는 경우 true를, 아닌 경우 false를 반환하도록 함수 solution을 완성해주세요.
//
//제한사항
//배열의 길이는 10만 이하입니다.
//배열의 원소는 0 이상 10만 이하인 정수입니다.

class test1 {
    fun solution(arr: IntArray): Boolean {
        var answer = true
        (1..arr.size).forEach { value ->
            if (!arr.contains(value)) {
                answer = false
            }
        }
        return answer
    }
}