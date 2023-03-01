package stack;

import java.io.*;
import java.util.Stack;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1874
 */
public class stack_01874_stackArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int start = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            boolean isPossible = false;

            int num = Integer.parseInt(br.readLine());
            while (start <= num) {
                stack.push(start++);
                isPossible = true;
                sb.append("+\n");
            }
            while (!stack.isEmpty() && stack.peek() >= num) {
                stack.pop();
                sb.append("-\n");
                isPossible = true;
            }

            if (!isPossible) {
                sb = new StringBuilder("NO");
                break;
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

}
