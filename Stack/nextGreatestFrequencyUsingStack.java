package Stack;
import java.util.Stack;

class nextGreatestFrequencyUsingStack{
    public static void main(String[] args) {
        int[] arr = {2,1,1,3,2,1};
        nextGreatestFrequency(arr);
    }

    public static void nextGreatestFrequency(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] freq = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            freq[i] = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) freq[i]++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && freq[stack.peek()] <= freq[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(arr[stack.peek()] + " ");
            }
            stack.push(i);
        }
    }
}