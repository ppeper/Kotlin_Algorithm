package level3

// n명이 입국심사를 위해 줄을 서서 기다리고 있습니다. 각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.
//
//처음에 모든 심사대는 비어있습니다. 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다. 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다. 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.
//
//모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.
//
//입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때, 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
//각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
//심사관은 1명 이상 100,000명 이하입니다.

class Immigration {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        var startTime: Long = 0
        // 최고로 걸릴수 있는 시간
        var endTime = times.sorted()[times.size - 1] * n.toLong()
        // 이진 탐색
        while (startTime < endTime) {
            val mid = (startTime + endTime) / 2
            val count = count(times, mid)
            // 심사가능 인원이 더적으면
            if (count < n) {
                startTime = mid + 1
            } else {
                endTime = mid
            }
        }
        answer = endTime
        return answer
    }

    private fun count(times: IntArray, endTime: Long): Long {
        var check: Long =  0
        times.forEach {
            check += (endTime / it)
        }
        return check
    }
}