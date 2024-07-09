package programmers.elice;

import java.io.*;
import java.util.*;

class 정리정돈 {

    static int[] numbers, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        answer = new int[m];
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = parseInt(st.nextToken()) - 1;
            int to = parseInt(st.nextToken()) - 1;
            int idx = parseInt(st.nextToken()) - 1;
            int[] buffer = new int[to - from + 1];
            System.arraycopy(numbers, from, buffer, 0, to - from + 1);
            Arrays.sort(buffer);
            answer[i] = buffer[idx];
        }
        for (int result : answer) {
            System.out.println(result);
        }
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }
}