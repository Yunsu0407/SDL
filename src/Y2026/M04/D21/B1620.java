package Y2026.M04.D21;

import java.util.*;
import java.io.*;

public class B1620 {
    public static void main(String[] args) throws IOException {
        makeDictionary();
    }

    public static String input1 = "26 5\r\n" + //
            "Bulbasaur\r\n" + //
            "Ivysaur\r\n" + //
            "Venusaur\r\n" + //
            "Charmander\r\n" + //
            "Charmeleon\r\n" + //
            "Charizard\r\n" + //
            "Squirtle\r\n" + //
            "Wartortle\r\n" + //
            "Blastoise\r\n" + //
            "Caterpie\r\n" + //
            "Metapod\r\n" + //
            "Butterfree\r\n" + //
            "Weedle\r\n" + //
            "Kakuna\r\n" + //
            "Beedrill\r\n" + //
            "Pidgey\r\n" + //
            "Pidgeotto\r\n" + //
            "Pidgeot\r\n" + //
            "Rattata\r\n" + //
            "Raticate\r\n" + //
            "Spearow\r\n" + //
            "Fearow\r\n" + //
            "Ekans\r\n" + //
            "Arbok\r\n" + //
            "Pikachu\r\n" + //
            "Raichu\r\n" + //
            "25\r\n" + //
            "Raichu\r\n" + //
            "3\r\n" + //
            "Pidgey\r\n" + //
            "Kakuna";

    public static void makeDictionary() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            String number = String.valueOf(i + 1);
            String name = br.readLine().trim();
            map.put(number, name);
            map.put(name, number);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; ++i) {
            String input = br.readLine().trim();
            String output = map.get(input);
            sb.append(output).append("\n");
        }

        System.out.println(sb.toString());
    }
}
