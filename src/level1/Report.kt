package level1

class Report {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = IntArray(id_list.size) {0}
        val report_map = hashMapOf<String, Int>()
        val report_list = report.distinct().groupBy {it.split(" ")[0]}
        report.distinct().forEach {
            val reports = it.split(" ")
            report_map[reports[1]] = report_map.getOrDefault(reports[1], 0) + 1
        }
        // 신고 당한횟수
        for(i in id_list.indices) {
            report_list[id_list[i]]?.forEach {
                if (k <= report_map.getOrDefault(it.split(" ")[1], 0)) answer[i]++
            }
        }
        return answer
    }
}