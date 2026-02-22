package Stack_Queues.monotonic_stack;

public class TrapingRainWater {
    public static int optimal(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int sum = 0;

        while (start < end) {
            if (height[start] <= height[end]) {
                if (height[start] >= maxLeft) {
                    maxLeft = height[start];
                } else {
                    sum += maxLeft - height[start];
                }
                start++;
            } else {
                if (height[end] >= maxRight) {
                    maxRight = height[end];
                } else {
                    sum += maxRight - height[end];
                }
                end--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(optimal(height));
    }
}
