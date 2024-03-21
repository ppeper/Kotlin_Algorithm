package programmers.level3;

import java.util.Arrays;

class 숫자게임 {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int start = 0;
        for (int i = 0; i < A.length; i++) {
            // 현재 A보다 B가 더 크면 가능
            if (A[start] < B[i]) start++;
        }
        return start;
    }
}
