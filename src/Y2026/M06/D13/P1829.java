package Y2026.M05.D13;

import java.util.*;
import java.io.*;

public class P1829 {
    public static String input1 = "6 4\n" +
            "1 1 1 0\n" +
            "1 2 2 0\n" +
            "1 0 0 1\n" +
            "0 0 0 1\n" +
            "0 0 0 3\n" +
            "0 0 0 3\n";

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] picture = new int[m][n];

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; ++j) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] answer = solution(m, n, picture);
        System.out.println(answer[0] + " " + answer[1]);
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2]; // [0] = 영역의 개수, [1] = 최대 영역의 크기
        answer[1] = Integer.MIN_VALUE;
        boolean[][] visit = new boolean[m][n];

        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (!visit[r][c] && picture[r][c] != 0) {
                    answer[0] = answer[0] + 1;
                    int area = 0;

                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[] { r, c });
                    area = area + 1;
                    visit[r][c] = true;

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int[] dr = { -1, +0, +1, +0 };
                        int[] dc = { +0, +1, +0, -1 };

                        for (int i = 0; i < dr.length; ++i) {
                            int nr = curr[0] + dr[i];
                            int nc = curr[1] + dc[i];

                            if (nr < 0 || nr >= m || nc < 0 || nc >= n || visit[nr][nc]
                                    || picture[r][c] != picture[nr][nc]) { // 범위를 벗어나거나 방문한 경우
                                continue; // 스킵
                            }

                            q.offer(new int[] { nr, nc });
                            area = area + 1;
                            visit[nr][nc] = true;
                        }
                    }

                    answer[1] = Math.max(answer[1], area);
                }
            }
        }

        return answer;
    }
}
