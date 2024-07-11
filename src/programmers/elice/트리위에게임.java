package programmers.elice;

import java.util.*;
import java.io.*;

class 트리위에게임 {

    static int n;

    static StringBuilder answer;
    static ArrayList<PriorityQueue<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        tree = new ArrayList<>();
        answer = new StringBuilder();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new PriorityQueue<>());
        }
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = parseInt(st.nextToken());
            int to = parseInt(st.nextToken());
            tree.get(from).add(to);
        }
        for (int i = 1; i <= n; i++) {
            // 1번 노드부터 최적의 경우 확인
            search(i, 0, 0, 0);
        }
        System.out.print(answer);
    }

    private static void search(int node, int turn, int firstPlayerScore, int secondPlayerScore) {
        if (turn % 2 == 0) {
            firstPlayerScore += node;
        } else {
            secondPlayerScore += node;
        }

        PriorityQueue<Integer> child = tree.get(node);

        if (child.isEmpty()) {
            if (secondPlayerScore <= firstPlayerScore) {
                answer.append(1).append("\n");
            } else {
                answer.append(0).append("\n");
            }
        } else {
            search(child.peek(), turn + 1, firstPlayerScore, secondPlayerScore);
        }

    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }
}