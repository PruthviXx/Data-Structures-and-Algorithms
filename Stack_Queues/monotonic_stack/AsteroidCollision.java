package Stack_Queues.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static int[] optimal(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            // if asteroid is positive or stack is empty
            if (st.isEmpty() || asteroid > 0) {
                st.push(asteroid);
                continue;
            }

            // if asteroid is negative and stack is not empty
            while (!st.isEmpty() && asteroid < 0) {
                int prevAst = st.peek();

                // if prevAsteroid is smaller is negative
                if (prevAst < 0) {
                    st.push(asteroid);
                    break;
                }
                // positive test scenarios
                // if prevAsteroid is smaller than current asteroid
                else if (prevAst < (asteroid * -1)) {
                    st.pop();
                    // in case all stack is empty and current asteroid is the largest one
                    if (st.isEmpty()) {
                        st.push(asteroid);
                        break;
                    }
                }
                // if prevAsteroid is greater than current asteroid
                else if (prevAst > (asteroid * -1)) {
                    break;
                }
                // if prevAsteroid is exactly equal to current asteroid
                else {
                    st.pop();
                    break;
                }
            }
        }

        int[] res = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(optimal(new int[] { 5, 10, -5 })));
    }
}
