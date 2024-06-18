package programmers.level3;

import java.util.*;

class 최고의집합 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if (s < n) return new int[]{-1};
        Arrays.fill(answer, s / n);
        int remain = s % n;
        for (int i = 0; i < remain; i++) {
            answer[i]++;
        }
        Arrays.sort(answer);
        return answer;
    }
}
