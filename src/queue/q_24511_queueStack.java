package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/24511
 */
public class q_24511_queueStack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        boolean[] stc = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stc[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        LinkedList<Integer> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (stc[i]) continue;
            q.add(val);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int n = Integer.parseInt(st.nextToken());
            q.addFirst(n);
            bw.write(q.pollLast() + " ");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
