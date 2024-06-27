package boj.Problem7727ST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class 효도 {

    static int[][] move = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N, M, answer;
    static int[][] board;
    static List<Pair> user;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());
        int sum = 0;
        user = new ArrayList<>();
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken()) - 1;
            int y = parseInt(st.nextToken()) - 1;
            user.add(new Pair(x, y));
            sum += board[x][y];
            board[x][y] = 0;
        }
        dfs(user.get(0).x, user.get(0).y, 0, 0, sum);
        System.out.println(answer);
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    private static void dfs(int x, int y, int work, int userIdx, int sum) {
        answer = Math.max(answer, sum);
        // 일을 다했을때
        if (work == 3) {
            if (userIdx + 1 < M) {
                dfs(user.get(userIdx + 1).x, user.get(userIdx + 1).y, 0, userIdx + 1, sum);
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + move[i][0], ny = y + move[i][1];
            if (nx < 0 || N <= nx || ny < 0 || N <= ny) continue;
            int buffer = board[nx][ny];
            board[nx][ny] = 0;
            dfs(nx, ny, work + 1, userIdx, sum + buffer);
            board[nx][ny] = buffer;
        }
    }
}
