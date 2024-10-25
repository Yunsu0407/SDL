package D241005_T0244_B16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16234 {
    public static void main(String[] args) throws IOException {
        peopleMoving();
    }

    public static int size;
    public static int down;
    public static int up;
    public static int[][] board;
    public static Node[][] nodes;
    public static boolean[][] unite;

    public static void peopleMoving() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        size = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        board = new int[size][size];
        nodes = new Node[size][size];
        unite = new boolean[size][size];

        for (int r = 0; r < size; ++r) {
            st = new StringTokenizer(br.readLine().trim());
            for (int c = 0; c < size; ++c) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for (int r = 0; r < size; ++r) {
            for (int c = 0; c < size; ++c) {
                nodes[r][c] = new Node(r, c);
            }
        }

        int cycle = 0;
        while (checkTotal()) {
            ++cycle;
            ArrayList<ArrayList<Ordinate>> unions = new ArrayList<>();
            setTrue();
            for (int r = 0; r < size; ++r) {
                for (int c = 0; c < size; ++c) {
                    if (unite[r][c]) {
                        if(nodes[r][c].totalRelation){
                            HashMap<Ordinate, Boolean> currMap = nodes[r][c].getUnion();
                            ArrayList<Ordinate> union = new ArrayList<>();
                            for (Map.Entry<Ordinate, Boolean> curr : currMap.entrySet()) {
                                Ordinate currOrd = curr.getKey();
                                boolean currState = curr.getValue();
                                if(currState){
                                    union.add(currOrd);
                                }
                            }
                            if(!union.isEmpty()){
                                unions.add(union);
                            }
                        }
                        unite[r][c] = !unite[r][c];
                    }

                }
            }

            for(ArrayList<Ordinate> union: unions){
                int sum = 0;
                int count = 0;
                int avg;
                for(Ordinate ord: union){
                    sum = sum + board[ord.row][ord.col];
                    ++count;
                }
                avg = sum / count;

                for(Ordinate ord: union){
                    board[ord.row][ord.col] = avg;
                }
            }

            for (int r = 0; r < size; ++r) {
                for (int c = 0; c < size; ++c) {
                    nodes[r][c].setRelation();
                }
            }
        }

        System.out.println(cycle);
    }

    public static boolean checkTotal() {
        boolean allCondition = false;
        for (int r = 0; r < size; ++r) {
            for (int c = 0; c < size; ++c) {
                allCondition = allCondition || nodes[r][c].totalRelation;
                if (allCondition) {
                    return allCondition;
                }
            }
        }
        return allCondition;
    }

    public static void setTrue() {
        for (boolean[] curr : unite) {
            Arrays.fill(curr, true);
        }
    }

    public static int ROW = 0;
    public static int COL = 1;
    public static int[][] cardinal = {   // 상 하 좌 우
            {-1, +1, +0, +0},
            {+0, +0, -1, +1}
    };

    public static class Node {
        public Ordinate me;
        public Edge edge;
        public boolean totalRelation;

        public Node(int row, int col) {
            me = new Ordinate(row, col);
            ArrayList<Ordinate> ords = new ArrayList<>();
            for (int i = 0; i < 4; ++i) {
                int nextRow = me.row + cardinal[ROW][i];
                int nextCol = me.col + cardinal[COL][i];
                if (!(nextRow < 0 || nextRow > size - 1 || nextCol < 0 || nextCol > size - 1)) {
                    ords.add(new Ordinate(nextRow, nextCol));
                }
            }
            edge = new Edge(me, ords);
            totalRelation = edge.setRelation();
        }

        public HashMap<Ordinate, Boolean> getUnion() {
            return edge.getUnion();
        }

        public void setRelation(){
            edge.setRelation();
        }
    }

    public static class Edge {
        public Ordinate me;
        public ArrayList<Ordinate> neighbor;
        public HashMap<Ordinate, Boolean> relationMap;
        public boolean totalRelation;

        public Edge(Ordinate me, ArrayList<Ordinate> ords) {
            this.me = me;
            neighbor = ords;
            relationMap = new HashMap<>();
            totalRelation = false;
        }

        public boolean setRelation() {
            for (Ordinate ord : neighbor) {
                int diff = me.getDiff(ord);
                boolean curr;
                if (diff >= down && diff <= up) {
                    curr = true;
                } else {
                    curr = false;
                }
                relationMap.put(ord, false);
                totalRelation = totalRelation || curr;
            }
            return totalRelation;
        }

        public HashMap<Ordinate, Boolean> getUnion() {
            return relationMap;
        }
    }

    public static class Ordinate {
        public int row;
        public int col;

        public Ordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getDiff(Ordinate other) {
            return Math.abs(board[row][col] - board[other.row][other.col]);
        }
    }
}
