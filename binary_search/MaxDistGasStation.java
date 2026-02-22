package binary_search;

import java.util.PriorityQueue;

public class MaxDistGasStation {

    public static class pair {
        double first;
        int second;

        public pair(double first, int second) {
            this.first = first;
            this.second = second;
        }

    }

    public static double findDist(int[] arr, int k) {
        int n = arr.length;
        int[] placedCount = new int[n - 1];
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

        for (int index = 0; index < n - 1; index++) {
            pq.add(new pair(arr[index + 1] - arr[index], index));
        }

        for (int gasStations = 1; gasStations <= k; gasStations++) {
            pair p = pq.poll();
            int index = p.second;
            placedCount[index]++;
            Double initialDiff = (double) (arr[index + 1] - arr[index]);
            Double diff = initialDiff / (double) (placedCount[index] + 1);
            pq.add(new pair(diff, index));
        }

        return pq.peek().first;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 6;
        System.out.println(findDist(arr, k));
    }
}