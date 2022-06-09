package lecture.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(new Point(scanner.nextInt(), scanner.nextInt()));
        }
        for (Point point : solution2(n, points)) {
            System.out.println(point.x + " " + point.y);
        }
    }

    private static List<Point> solution(int n, List<Point> points) {
        Collections.sort(points);
        return points;
    }

    private static List<Point> solution2(int n, List<Point> points) {
        points.sort(Comparator.comparingInt((Point point) -> point.x)
            .thenComparingInt((Point point) -> point.y));
        return points;
    }

    private static int[][] solution3(int n, int[][] points) {
        Arrays.sort(points, Comparator.comparingInt((int[] point) -> point[0])
            .thenComparingInt((int[] point) -> point[1]));

        Arrays.sort(points, (o1, o2) -> {
            int result = Integer.compare(o1[0], o2[0]);
            if (result == 0) {
                result = Integer.compare(o1[1], o2[1]);
            }
            return result;
        });

        return points;
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            int result = Integer.compare(this.x, o.x);
            if (result == 0) {
                result = Integer.compare(this.y, o.y);
            }
            return result;
        }
    }

}
