package level2

import kotlin.math.min

// 조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
//ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
//
//조이스틱을 각 방향으로 움직이면 아래와 같습니다.
//
//  ▲ - 다음 알파벳
//  ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
//  ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
//  ▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
//예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.
//
//- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
//- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
//- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
//따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
//만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
//
//제한 사항
//name은 알파벳 대문자로만 이루어져 있습니다.
//name의 길이는 1 이상 20 이하입니다.

class JoyStick {
    fun solution(name: String): Int {
        // 최대로 이동해야하는 move
        var move = name.length - 1
        var answer = 0
        for (i in name.indices) {
            // 바꾸는 비용 더해준다
            answer += min('Z' - name[i] + 1, name[i] - 'A')
            // A를 만나면 양옆의 단어의 위치를 찾아준다
            if (name[i] == 'A') {
                var cursor = i
                // 연속된 A가 있으면 cursor를 계속 이동
                while (cursor < name.length && name[cursor] == 'A') {
                    cursor++
                }
                val left = if (i - 1 < 0) 0 else i - 1
                val right = if (cursor > name.length) 0 else cursor
                // 앞으로 갔다가 뒤로가는 경우
                move = min(move, 2 * left + name.length - right)
                // 뒤로 갔다가 앞으로 가는경우
                move = min(move, 2 * (name.length - right) + left)
            }
        }
        return answer + move
    }
}