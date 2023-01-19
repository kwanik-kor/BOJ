package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1725
 */
public class stack_01725_histogram {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 2];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ret = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for(int i = 1; i <= N + 1; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int height = arr[stack.pop()];
                int width = i - stack.peek() - 1;
                ret = Math.max(ret, height * width);
            }
            stack.push(i);
        }

        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
        br.close();
    }

}
