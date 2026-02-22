import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public static void generate(String curr, int open, int closed, int total, List<String> list) {
        if (curr.length() == 2 * total) {
            list.add(curr);
            return;
        }

        if (open < total) {
            generate(curr + "(", open + 1, closed, total, list);
        }

        if (closed < open) {
            generate(curr + ")", open , closed+1, total, list);
        }
    }

    public static List<String> solve(int n) {
        List<String> list = new ArrayList<>();
        generate("", 0, 0, n, list);
        return list;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> list = solve(n);

        for (String string : list) {
            System.out.print("[ " + string + " ] ");
        }
    }
}
