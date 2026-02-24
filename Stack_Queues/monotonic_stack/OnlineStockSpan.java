import java.util.*;

class StockSpanner{
    Stack<int[]> st;
    int indx;

    public StockSpanner(){
        st = new Stack<>();
        indx = -1;
    }

    // Time: O(2n), Space: O(n)
    public int next(int price){
        // pop until greater element
        while(!st.isEmpty() && st.peek()[1] <= price){
            st.pop();
        }

        indx++;
        int ans = indx - (st.isEmpty() ? -1 : st.peek()[0]);
        st.push(new int[]{indx,price});
        
        return ans;
    }
}

public class OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}
