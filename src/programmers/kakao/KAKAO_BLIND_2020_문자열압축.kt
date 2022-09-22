package programmers.kakao


class KAKAO_BLIND_2020_문자열압축 {
    fun solution(s: String): Int {
        var answer = s.length
        val limit = s.length / 2
        for (i in 1..limit) {
            answer = answer.coerceAtMost(afterCompression(s, i))
        }
        return answer
    }

    private fun afterCompression(s: String, unit: Int): Int {
        val output = StringBuilder()
        var count = 1
        var curr = ""
        var i = 0
        while (i < s.length) {
            // 처음시작
            if (curr == "") {
                curr = s.substring(i, i + unit)
                i += unit
                continue
            }
            // 남은 문자열이 더 짧다면
            if (i + unit > s.length) {
                if (count == 1) {
                    output.append(curr)
                } else {
                    output.append(count).append(curr)
                }
                // 마지막으로 붙여준다.
                output.append(s.substring(i))
            } else {
                // 전에 짤랐던 문자열과 같다면 compress
                if (curr == s.substring(i, i + unit)) {
                    count += 1
                } else {
                    // 전에 나왔던 문자열은 한번만 반복
                    if (count == 1) {
                        output.append(curr)
                    } else {
                        // 몇번 반복되어 압축되었는지 같이 저장
                        output.append(count).append(curr)
                        // coubnt 초기화
                        count = 1
                    }
                    // curr를 지금 자른 문자열로 바꿔줌
                    curr = s.substring(i, i + unit)
                }
                // 마지막이라면
                if (i + unit == s.length) {
                    if (count == 1) {
                        output.append(curr)
                    } else {
                        output.append(count).append(curr)
                    }
                }
            }
            i += unit
        }
        return output.length
    }
}