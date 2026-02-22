import java.util.ArrayList;
import java.util.List;

public class CombinationIII {
    public static void optimal(int n, int k, int sum, int index, ArrayList<Integer> ds, List<List<Integer>> list) {
        if (ds.size() > k) {
            return;
        }

        if (ds.size() == k && sum == n) {
            list.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i <= 9; i++) {
            if (sum + i > n) {
                break;
            }

            ds.add(i);
            optimal(n, k, sum + i, i + 1, ds, list);
            ds.remove(ds.size() - 1);
            String digits = "";

        }

    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int n = 7;
        int k = 3;
        optimal(n, k, 0, 1, new ArrayList<>(), list);
        System.out.println(list);
        String str = "pruthviraj";

        System.out.println(str.substring(1));
    }
}
