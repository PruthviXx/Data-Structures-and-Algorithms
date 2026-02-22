import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) {
        // Your code here
        int n = G.length;
        if (solve(i, G, color, n, C) == true)
            return true;
        return false;
    }

    private static boolean isSafe(int node, List<Integer>[] G, int[] color, int n, int col) {
        List<Integer> list = G[node];
        for (int it : list) {
            if (color[it] == col)
                return false;
        }
        return true;
    }

    private static boolean solve(int node, List<Integer>[] G, int[] color, int n, int m) {
        if (node == n)
            return true;

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, G, color, n, i)) {
                color[node] = i;
                boolean res = solve(node + 1, G, color, n, m);
                if (res) {
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int N = 3, M = 1;
        List<Integer>[] G = new ArrayList[N];
        for (int i = 0; i < 1; i++) {
            G[i] = new ArrayList<>();
        }
        G[0].add(1);
        G[1].add(2);

        System.out.println(5 + "");

        int[] color = new int[N];
        boolean ans = graphColoring(G, color, 0, M);
        if (ans == true)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
