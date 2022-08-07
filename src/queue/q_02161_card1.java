package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2161
 */
public class q_02161_card1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        IntStream.rangeClosed(1, N).forEach(q::add);
        while (!q.isEmpty()) {
            bw.write(q.poll() + " ");
            if (!q.isEmpty()) {
                q.add(q.poll());
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
