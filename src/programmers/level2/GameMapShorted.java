package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

class GameMapShorted {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] visited;
    static int answer;

    public int solution(int[][] maps) {
        return search(maps);
    }

    private int search(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == maps.length - 1 && curr[1] == maps[0].length - 1) {
                return visited[curr[0]][curr[1]];
            }
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i], ny = curr[1] + dy[i];
                if (nx < 0 || maps.length <= nx || ny < 0 || maps[0].length <= ny) continue;
                if (maps[nx][ny] == 0) continue;
                if (visited[nx][ny] != 0) continue;
                visited[nx][ny] = visited[curr[0]][curr[1]] + 1;
                q.add(new int[] {nx, ny});
            }
        }
        return -1;
    }
}
