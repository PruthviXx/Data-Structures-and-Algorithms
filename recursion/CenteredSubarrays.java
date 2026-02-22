import java.util.HashSet;

public class CenteredSubarrays {
    public static int solve(int[] nums, int indx, HashSet<Integer> set, int sum, int n, int count) {
        if (indx == n) {
            if (set.contains(sum)) {
                return 1;
            } else {
                return 0;
            }
        }

        sum = sum + nums[indx];
        set.add(nums[indx]);
        count += solve(nums, indx + 1, set, sum, n, count);

        sum = sum - nums[indx];
        set.remove(nums[indx]);
        count += solve(nums, indx + 1, set, sum, n, count);

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { -1,1,0};

        System.out.println(solve(nums,0, new HashSet<Integer>(), 0, nums.length, 0));
    }
}
