import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    public static void optimal(int[] nums, int index, List<Integer> ds, List<List<Integer>> list) {
        list.add(new ArrayList<Integer>(ds));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])
                continue;
            ds.add(nums[i]);
            optimal(nums, i + 1, ds, list);
            ds.remove(ds.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 2, 3, 3 };
        List<List<Integer>> list = new ArrayList<>(); // O(n)
        Arrays.sort(nums); // n logn
        optimal(nums, 0, new ArrayList<>(), list); // O(2^n)

        for (List<Integer> list2 : list) {
            System.out.print("[");
            for (Integer number : list2) {
                System.out.print(number + ",");
            }
            System.out.print("], ");
        }
    }
}
