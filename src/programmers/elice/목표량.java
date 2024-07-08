package programmers.elice;

import java.io.*;
import java.util.*;

class Main {

    static char[] pick;
    static String problem;
    static boolean[] visited;
    static int n, min, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        problem = br.readLine();
        n = problem.length();
        answer = Integer.MAX_VALUE;
        pick = new char[n];
        visited = new boolean[n];
        min = Integer.parseInt(problem);
        search(0);
        System.out.println(answer);
    }

    private static void search(int idx) {
        if (n == idx) {
            int number = convertNumber();
            if (min < number && number < answer) {
                answer = number;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            pick[idx] = problem.charAt(i);
            search(idx + 1);
            visited[i] = false;
        }
    }

    private static int convertNumber() {
        StringBuilder number = new StringBuilder();
        for (char c : pick) {
            int num = c - '0';
            number.append(num);
        }
        return Integer.parseInt(number.toString());
    }
}