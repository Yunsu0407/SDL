package Y2026.M04.D10;

import java.util.*;
import java.io.*;

public class B11866 {
    public static void main(String[] args) throws IOException {
        josephusProblem();
    }

    public static void josephusProblem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            list.add(i + 1);
        }

        int idx = k - 1;
        List<Integer> ans = new ArrayList<>();
        while (true) {
            int val = list.remove(idx);
            ans.add(val);
            if (list.isEmpty()) {
                break;
            }
            idx = (idx + k - 1) % list.size();
        }

        StringBuilder sb = new StringBuilder("<");
        for (int i = 0; i < ans.size() - 1; ++i) {
            sb.append(ans.get(i)).append(", ");
        }
        sb.append(ans.get(ans.size() - 1)).append(">");

        System.out.println(sb.toString());
    }
}
