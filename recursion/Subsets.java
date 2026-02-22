import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void generateSubsets(int[] nums, int index, List<Integer> subList, List<List<Integer>> list, int n) {
        if (index == n) {
            list.add(new ArrayList<>(subList));
            subList = new ArrayList<>();
            return;
        }

        subList.add(nums[index]);
        generateSubsets(nums, index + 1, subList, list, n);
        subList.removeLast();
        generateSubsets(nums, index + 1, subList, list, n);
    }

    public static List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        generateSubsets(nums, 0, new ArrayList<Integer>(), list, nums.length);
        return list;
    }

    private static List<List<Integer>> usingBitwise(int[] nums, int n) {
        int subsets = 1 << n;
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        for (int i = 0; i < subsets; i++) { // O(2^n)
            // ds = new ArrayList<>();
            for (int j = 0; j < n; j++) { // O(n)
                if ((i | (1 << j)) == i) {
                    ds.add(nums[j]);
                }
                // 0011
                // 0010
            }
            list.add(new ArrayList<>(ds));
            ds.clear();
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> list = usingBitwise(nums, nums.length);

        for (List<Integer> list2 : list) {
            System.out.print("[ ");
            for (Integer list3 : list2) {
                System.out.print(list3 + " ");
            }
            System.out.print(" ]  ");
        }
    }
}
