package Y2026.M08.D26;

import java.util.*;
import java.io.*;

public class S6806 {
    public static void main(String[] args) throws IOException {
        cardGame();
    }

    public static void cardGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            // init
            listG = new ArrayList<>();
            listI = new ArrayList<>();
            winG = winI = 0;

            // i/o & setting
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            while (st.hasMoreTokens()) {
                int val = Integer.parseInt(st.nextToken());
                listG.add(val);
            }
            for (int j = 1; j <= 18; ++j) {
                if (!listG.contains(j)) {
                    listI.add(j);
                }
            }

            // logic
            dfs(new boolean[9], 0, 0, 0);

            // i/o
            String line = String.format("#%d %d %d\n", (i + 1), winG, winI);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static List<Integer> listG;
    public static List<Integer> listI;
    public static int winG;
    public static int winI;

    public static void dfs(boolean[] used, int depth, int scoreG, int scoreI) {
        if (depth == 9) {
            if (scoreG > scoreI) {
                ++winG;
            } else if (scoreG < scoreI) {
                ++winI;
            }

            return;
        }

        int valG = listG.get(depth);
        for (int i = 0; i < listI.size(); ++i) {
            if (!used[i]) {
                used[i] = true;
                int valI = listI.get(i);

                if (valG > valI) {
                    dfs(used, depth + 1, scoreG + valG + valI, scoreI);
                } else if (valG < valI) {
                    dfs(used, depth + 1, scoreG, scoreI + valG + valI);
                }

                used[i] = false;
            }
        }
    }
}
