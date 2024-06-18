package programmers.level3;

class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int size = w * 2 + 1; // 기지국의 범위
        int start = 1;

        for (int station: stations) {
            // 현재 기지국이 해결할 수 있는 최대 왼쪽
            int left = station - w - 1;
            // 기지국 추가 설치
            if (start <= left) {
                int length = left - start + 1;
                // 기지국 설치
                int count = length / size;
                if (length % size == 0) {
                    answer += count;
                } else {
                    answer += count + 1;
                }
            }
            // 다음 시작점 -> 설치된 기지국의 마지막 전파 범위
            start = station + w + 1;
        }

        // 마지막 전파 범위 확인
        if (start <= n) {
            int length = n - start + 1;
            // 기지국 설치
            int count = length / size;
            if (length % size == 0) {
                answer += count;
            } else {
                answer += count + 1;
            }
        }
        return answer;
    }
}