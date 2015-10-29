package inward;

import java.util.*;
import java.lang.*;
 
public class InwardSprial
{
        private static Point current = new Point(0, 0);
        private static Direction lastMove = Direction.RIGHT;
        private static int width;
        private static int height;
        private static Set<Point> visited;
 
        public static void main(String[] args) throws java.lang.Exception {
                int[][] test = { {1}, { 7}, { 3} } ;
                spiralPrint(test);
        }
 
        public static synchronized void spiralPrint(int[][] data) {
                width = data[0].length;
                height = data.length;
                int numPoints = width * height;
                visited = new HashSet<Point>();
                while (visited.size() < numPoints) {
                        System.out.println(data[current.y][current.x]);
                        visited.add(current);
                        current = getNextMove();
                }
        }
 
        private static Point getNextMove() {
                //first see if we can continue in our current direction
                int x = current.x;
                int y = current.y;
                Point nextPoint = lastMove.nextPoint(x, y);
                if (! visited.contains(nextPoint) 
                                && nextPoint.x < width && nextPoint.x >= 0 
                                && nextPoint.y < height && nextPoint.y >= 0) {
                        return nextPoint;
                }
                
                //couldn't continue in the original direction, pick a new one
                lastMove = lastMove.turnRight();
                return lastMove.nextPoint(x, y);
        }
 
        private static class Point {
                private Integer x;
                private Integer y;
 
                public Point(Integer x, Integer y) {
                        this.x = x;
                        this.y = y;
                }
 
                @Override
                public boolean equals(Object anotherObj) {
                        Point test = (Point) anotherObj;
                        return test.x == this.x && test.y == this.y;
                }
 
                @Override
                public int hashCode() {
                        return this.x.hashCode() ^ this.y.hashCode();
                }
        }
 
        private static enum Direction {
                UP, DOWN, LEFT, RIGHT;
                
                public Point nextPoint(int x, int y) {
                        if (this == Direction.RIGHT) {
                                return new Point(x + 1, y);
                        }
                        if (this == Direction.LEFT) {
                                return new Point(x - 1, y);
                        }
                        if (this == Direction.DOWN) {
                                return new Point(x, y + 1);
                        }
                        //must be Direction.UP
                        return new Point(x, y - 1);
                }
                
                public Direction turnRight() {
                        if (this == Direction.RIGHT) {
                                return Direction.DOWN;
                        }
                        if (this == Direction.LEFT) {
                                return Direction.UP;
                        }
                        if (this == Direction.DOWN) {
                                return Direction.LEFT;
                        }
                        //must be Direction.UP
                        return Direction.RIGHT;
                }
        }
}