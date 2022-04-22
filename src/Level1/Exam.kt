package Level1

// 문제 설명
//수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
//
//1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//
//1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//제한 조건
//시험은 최대 10,000 문제로 구성되어있습니다.
//문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
//가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

class Exam {
    fun solution(answers: IntArray): IntArray {
        val answer = arrayListOf<Int>()
        val person1 = intArrayOf(1, 2, 3, 4, 5)
        val person2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val person3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        val scoreList = intArrayOf(0, 0, 0)
        // 맞힌 개수
        answers.forEachIndexed { index, value ->
            if (person1[index % person1.size] == value) {
                scoreList[0]++
            }
            if (person2[index % person2.size] == value) {
                scoreList[1]++
            }
            if (person3[index % person3.size] == value) {
                scoreList[2]++
            }
        }
        val max = scoreList.maxOrNull()

        if (scoreList[0] == max) {
            answer.add(1)
        }
        if (scoreList[1] == max) {
            answer.add(2)
        }
        if (scoreList[2] == max) {
            answer.add(3)
        }

        return answer.toIntArray()
    }
}

fun main() {
    val ex = Exam()
    println(ex.solution(intArrayOf(1,2,3,4,5)))
}