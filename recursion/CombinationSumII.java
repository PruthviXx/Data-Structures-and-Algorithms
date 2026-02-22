import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void findCombinationSum2(int[] arr, int target, List<List<Integer>> ans, List<Integer> ds,
            int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > target) {
                return;
            }
            ds.add(arr[i]);
            findCombinationSum2(arr, target - arr[i], ans, ds, i + 1);
            ds.remove(ds.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2, 2 };
        int target = 4;
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        findCombinationSum2(arr, target, list, new ArrayList<>(), 0);

        for (List<Integer> list2 : list) {
            System.out.println(list2.toString());
        }
    }
}
