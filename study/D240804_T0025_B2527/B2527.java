package D240804_T0025_B2527;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2527 {
    public static void main(String[] args) throws IOException {

    }

    public static void judgeSquare() throws IOException {

    }

    public static class Area implements Comparable<Area> {
        Line bottom, right, top, left;

        public Area(int x1, int y1, int x2, int y2) {
            this.bottom = new Line(x1, x2, y1, y2, true, true);
            this.right = new Line(x1, x2, y1, y2, false, true);
            this.top = new Line(x1, x2, y1, y2, true, false);
            this.left = new Line(x1, x2, y1, y2, false, false);
        }

        public int checkBottom(Area other) {
            this.bottom.check(other);
        }

        public int checkRight(Area other) {

        }

        public int checkTop(Area other) {

        }

        public int checkLeft(Area other) {

        }

        @Override
        public int compareTo(Area other) {

            return 0;
        }
    }

    public static class Line {
        private int start, end, fix;
        private boolean isHorizontal;

        public Line(int x1, int y1, int x2, int y2, boolean isHorizontal, boolean isBottomOrRight) {
            if (isBottomOrRight) {
                if (isHorizontal) {   // 하
                    setDetail(x1, x2, y1);
                } else {    // 우
                    setDetail(y1, y2, x2);
                }
            } else {
                if (isHorizontal) {   // 상
                    setDetail(x1, x2, y2);
                } else {    // 좌
                    setDetail(y1, y2, x1);
                }
            }
        }

        public void setDetail(int start, int end, int fix) {
            this.start = start;
            this.end = end;
            this.fix = fix;
        }

        public int check(Area area) {

        }
    }
}
