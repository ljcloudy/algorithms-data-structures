package com.cloudy.leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
//        Point[] nums = {1, 1, 1, 0};
//        [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]

        Point[] points = {
                new Point(1, 1),
                new Point(3, 2),
                new Point(5, 3),
                new Point(4, 1),
                new Point(2, 3),
                new Point(1, 4),
        };

        int result = maxPoints(points);
        System.out.println(result);
        System.out.println(-0.0 == 0.0);

    }

    public static int maxPoints(Point[] points) {
        if (points.length <= 1)
            return points.length;
        int result = 1;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap();
            int samePoint = 0;

            for (int j = 0; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoint++;
                } else {
                    map.put(getPointStr(slope(points[j], points[i])), map.getOrDefault(getPointStr(slope(points[j], points[i])), 0) + 1);
                }
            }
            result = Math.max(result,samePoint);
            for (Integer count : map.values()) {
                result = Math.max(result,count+samePoint);
            }
        }

        return result;
    }

    public static Point slope(Point a, Point b) {

        int dx = a.x - b.x;
        int dy = a.y - b.y;
        if (dx == 0) {
            return new Point(1, 0);
        }
        if (dy == 0) {
            return new Point(0, 1);
        }
        int g = gcd(Math.abs(dy), Math.abs(dx));
        dy /= g;
        dx /= g;
        if (dx < 0) {
            dy = -dy;
            dx = -dx;
        }

        return (new Point(dy, dx));
    }

    private static int gcd(int a, int b) {

        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    private static String getPointStr(Point point) {
        return point.x + "/" + point.y;
    }

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }


}