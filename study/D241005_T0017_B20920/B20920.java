package D241005_T0017_B20920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B20920 {
    public static void main(String[] args) throws IOException {
        wordSorting();
    }

    public static void wordSorting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        final int SIZE = Integer.parseInt(st.nextToken());
        final int LIMIT = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> myMap = new HashMap<>();
        for (int i = 0; i < SIZE; ++i) {
            String curr = br.readLine().trim();
            int length = curr.length();
            if (length < LIMIT) { // 글자수 제한 보다 작으면 패스
                continue;
            }
            if (myMap.isEmpty()) {    // 맵이 비어있으면
                myMap.put(curr, 1); // 그냥 넣음
            } else {    // 비어있지 않으면
                if (myMap.containsKey(curr)) {    // 이미 들어있으면
                    int value = myMap.get(curr);    // 벨류를 가져와서
                    myMap.replace(curr, value + 1);  // 한 개 증가시킴
                } else {    // 들어있지 않으면
                    myMap.put(curr, 1);  // 넣어줌
                }
            }
        }
        br.close();

        // 단어를 하나씩 꺼내서 빈도수를 키로 가지는 해쉬맵에 넣는다.
        HashMap<Integer, ArrayList<String>> sortedMap = new HashMap<>();
        for (Map.Entry<String, Integer> currSet : myMap.entrySet()) {
            int length = currSet.getValue();
            String word = currSet.getKey();

            ArrayList<String> targetList;
            if (sortedMap.isEmpty()) {
                targetList = new ArrayList<>();
                targetList.add(word);
                sortedMap.put(length, targetList);
            } else {
                if (sortedMap.containsKey(length)) {
                    targetList = sortedMap.get(length);
                    targetList.add(word);
                    sortedMap.replace(length, targetList);
                } else {
                    targetList = new ArrayList<>();
                    targetList.add(word);
                    sortedMap.put(length, targetList);
                }
            }
        }

        TreeMap<Integer, ArrayList<String>> finalMap = new TreeMap<>(Comparator.reverseOrder());
        finalMap.putAll(sortedMap);

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, ArrayList<String>> currSet: finalMap.entrySet()){
            ArrayList<String> finalList = sorting(currSet.getValue());
            for(String currWord: finalList){
                sb.append(currWord).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static ArrayList<String> sorting(ArrayList<String> list){
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 길이에 따라 내림차순 정렬
                int lengthCompare = Integer.compare(s2.length(), s1.length());
                if (lengthCompare != 0) {
                    return lengthCompare;
                }
                // 길이가 같다면 알파벳 순으로 오름차순 정렬
                return s1.compareTo(s2);
            }
        });
        return list;
    }
}
