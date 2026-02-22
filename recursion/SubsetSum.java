import java.util.ArrayList;

public class SubsetSum {
    public static void getSubsetSum(int[] arr, ArrayList<Integer> list, int sum, int index) {
        if (index == arr.length) {
            list.add(sum);
            return;
        }
        // pick the element
        getSubsetSum(arr, list, sum + arr[index], index + 1);
        // not pick the element
        getSubsetSum(arr, list, sum, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 6, 7 };
        ArrayList<Integer> list = new ArrayList<>();
        getSubsetSum(arr, list, 0, 0);

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

}
