package study.Y2024.M07.D240720_T0459_B7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
생 토마토: 0
숙성된 토마토: 1
노 토마토: -1

숙성된 토마토들은 사방향으로 영향을 미친다.
하루가 지나면 사방향으로 익힌다.
대각선은 영향을 주지 않는다.
다 익히려면 몇일이 걸리는가
입력:
행 열
토마토 상태 배열 행*열
 */

public class B7576 {
    public static void main(String[] args) throws IOException {
        ripenTomato();
    }

    public static void ripenTomato() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int colSize = Integer.parseInt(st.nextToken());
        int rowSize = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[rowSize][colSize];
        Graph graph = new Graph(rowSize, colSize);

        for (int row = 0; row < rowSize; ++row) {
            st = new StringTokenizer(br.readLine().trim());
            for (int col = 0; col < colSize; ++col) {
                int state = Integer.parseInt(st.nextToken());
                matrix[row][col] = state;
                graph.addVertex(new Vertex(state, row, col));
            }
        }   // 그래프 배열로 저장

        graph.setVertices();    // 그래프 설정
        int day = graph.calculate();
        System.out.printf("%d", day);
    }

    public static class Graph {
        private int rowSize, colSize;
        private LinkedList<Vertex> vertices;
        private LinkedList<Vertex> fresh;
        private LinkedList<Vertex> riped;

        public Graph(int rowSize, int colSize) {
            this.rowSize = rowSize;
            this.colSize = colSize;
            this.vertices = new LinkedList<>();
            this.fresh = new LinkedList<>();
            this.riped = new LinkedList<>();
        }

        public void addVertex(Vertex vertex) {
            vertex.findAdjacent(rowSize, colSize);
            vertices.add(vertex);
            if (vertex.state == 0) {
                fresh.add(vertex);
            }
            if (vertex.state == 1) {
                riped.add(vertex);
            }
        }

        public void setVertices() {
            for (Vertex vertex : vertices) {
                vertex.setAdjacent(vertices);
            }
        }

        public int calculate() {
            int day = 0;

            while (!fresh.isEmpty()) {
                LinkedList<Vertex> newRiped = new LinkedList<>();

                for (Vertex vertex : riped) {
                    if (vertex.hasFresh(vertex, fresh, newRiped)) {
                        riped.remove(vertex);
                    }
                }

                riped = newRiped;
                ++day;
            }

            return day;
        }
    }

    public static class Vertex {
        private int state;
        private Coordinate coordinate;
        private LinkedList<Vertex> adjacent;
        private LinkedList<Coordinate> coordinates;

        public Vertex(int state, int row, int col) {
            this.state = state;
            this.coordinate = new Coordinate(row, col);
            this.adjacent = new LinkedList<>();
            this.coordinates = new LinkedList<>();
        }

        public void findAdjacent(int rowSize, int colSize) {
            int row = this.coordinate.row;
            int col = this.coordinate.col;

            if (row == 0) {
                if (col == 0) {
                    coordinates.add(new Coordinate(row, col + 1));
                    coordinates.add(new Coordinate(row + 1, col));
                } else if (col == colSize - 1) {
                    coordinates.add(new Coordinate(row, colSize - 2));
                    coordinates.add(new Coordinate(row + 1, colSize - 1));
                } else {
                    coordinates.add(new Coordinate(row, col - 1));
                    coordinates.add(new Coordinate(row, col + 1));
                    coordinates.add(new Coordinate(row + 1, col));
                }
            } else if (row == rowSize - 1) {
                if (col == 0) {
                    coordinates.add(new Coordinate(row - 1, col));
                    coordinates.add(new Coordinate(row, col + 1));
                } else if (col == colSize - 1) {
                    coordinates.add(new Coordinate(row, col - 1));
                    coordinates.add(new Coordinate(row - 1, col));
                } else {
                    coordinates.add(new Coordinate(row, col - 1));
                    coordinates.add(new Coordinate(row, col + 1));
                    coordinates.add(new Coordinate(row - 1, col));
                }
            } else {
                if (col == 0) {
                    coordinates.add(new Coordinate(row - 1, col));
                    coordinates.add(new Coordinate(row + 1, col));
                    coordinates.add(new Coordinate(row, col + 1));
                } else if (col == colSize - 1) {
                    coordinates.add(new Coordinate(row - 1, col));
                    coordinates.add(new Coordinate(row + 1, col));
                    coordinates.add(new Coordinate(row, col - 1));
                } else {
                    coordinates.add(new Coordinate(row - 1, col));
                    coordinates.add(new Coordinate(row + 1, col));
                    coordinates.add(new Coordinate(row, col - 1));
                    coordinates.add(new Coordinate(row, col + 1));
                }
            }
        }

        public void setAdjacent(LinkedList<Vertex> vertices) {
            for (Coordinate coordinate : coordinates) {
                for (Vertex vertex : vertices) {
                    if (vertex.equals(coordinate)) {
                        adjacent.add(vertex);
                    }
                }
            }
        }

        @Override
        public boolean equals(Object obj) {
            Coordinate coordinate = (Coordinate) obj;
            return this.coordinate.row == coordinate.row && this.coordinate.col == coordinate.col;
        }

        public boolean hasFresh(Vertex target, LinkedList<Vertex> fresh, LinkedList<Vertex> newRiped) {
            boolean hasFresh = false;
            for (Vertex vertex : adjacent) {
                if (vertex.equals(target.coordinate)) {
                    fresh.remove(target);
                    newRiped.add(target);
                    hasFresh = true;
                }
            }
            return hasFresh;
        }
    }

    public static class Coordinate {
        private int row, col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
