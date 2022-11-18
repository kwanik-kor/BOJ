package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2812
 */
public class greedy_02812_makeBigger {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String line = br.readLine();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int n = line.charAt(i) - '0';
            if (stack.isEmpty() || K == 0) {
                stack.addLast(n);
                continue;
            }

            while (!stack.isEmpty() && stack.peekLast() < n && K > 0) {
                stack.removeLast();
                K--;
            }

            stack.addLast(n);
        }

        while (K > 0) {
            stack.removeLast();
            K--;
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pollFirst() + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
