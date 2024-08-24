package D240814_T1328_B14889;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class B14889 {
    public static void main(String[] args) throws IOException {
        makeTeam();
    }

    public static int[][] preference;
    public static int min = Integer.MAX_VALUE;

    public static void makeTeam() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int ENTRY = Integer.parseInt(br.readLine().trim());
        preference = new int[ENTRY][ENTRY];

        // 배열 수령
        for (int row = 0; row < ENTRY; ++row) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int col = 0; col < ENTRY; ++col) {
                preference[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        final int SIZE = ENTRY / 2;
        int[] members = new int[SIZE];
        int count = 0;
        members[count++] = 0;
        for (int i = 1; i <= ENTRY - 1; ++i) { // 1 ~ N-1
            repetition(members, i, count, ENTRY);   // count = 1
        }

        System.out.printf("%d", min);
    }

    public static void repetition(int[] members, int member, int count, int ENTRY) {
        if (count < ENTRY / 2) {
            for (int j = member; j <= ENTRY - 1; ++j) {
                members[count] = j;
                repetition(members, j + 1, count + 1, ENTRY);
            }
        } else {
            int value = getScore(members, ENTRY);
            if (value < min) {
                min = value;
            }
        }
    }

    public static int getScore(int[] members, int ENTRY) {
        int size = members.length;
        boolean[] checker = new boolean[ENTRY];
        LinkedList<Integer> team_start = new LinkedList<>();
        LinkedList<Integer> team_link = new LinkedList<>();

        for (int i = 0; i < size; ++i) {
            team_start.add(members[i]);
            checker[members[i]] = true;
        }

        for (int i = 0; i < checker.length; ++i) {
            if (!checker[i]) {
                team_link.add(i);
            }
        }

        int score_start = 0;
        int score_link = 0;

        for (int i = 0; i < size; ++i) {
            int target_start = team_start.remove(0);
            int target_link = team_link.remove(0);
            for (int curr : team_start) {
                score_start = score_start + preference[target_start][curr];
            }
            for (int curr : team_link) {
                score_link = score_link + preference[target_link][curr];
            }
            team_start.add(target_start);
            team_link.add(target_link);
        }

        return Math.abs(score_start - score_link);
    }
}
