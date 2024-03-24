package blind75.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
   public class DistancePoint {
        int[] point;

        double distance;

        public DistancePoint(int[] point, double distance){
            this.distance = distance;
            this.point = point;
        }

        public int[] getPoint() {
            return point;
        }

        public double getDistance() {
            return distance;
        }

    }


    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> kClosest = new PriorityQueue<>(Comparator.comparingDouble(a -> Math.sqrt(a[0] * a[0] + a[1] * a[1])));

        for (int i = 0; i < points.length; i ++) {
            kClosest.offer(points[i]);
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = kClosest.poll();
        }

        return res;
    }

    // More efficient version with no object creation
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> kClosest = new PriorityQueue<int[]>((a,b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));

        for (int i = 0; i < points.length; i ++) {
            kClosest.offer(points[i]);
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = kClosest.poll();
        }

        return res;
    }
}
