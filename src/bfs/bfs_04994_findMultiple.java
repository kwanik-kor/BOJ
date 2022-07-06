package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4994
 * 2. 풀이
 *  - 모듈러 연산을 이용한 너비 우선 탐색
 */
public class bfs_04994_findMultiple {

    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            Integer N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            visit = new boolean[200];

            Queue<Node> q = new LinkedList<>();
            q.add(new Node(1, "1"));
            visit[1] = true;

            while (!q.isEmpty()) {
                Node now = q.poll();
                if (now.mod == 0) {
                    bw.write(now.str + "\n");
                    break;
                }

                int nextMod = (now.mod * 10) % N;
                if (!visit[nextMod]) {
                    visit[nextMod] = true;
                    q.add(new Node(nextMod, now.str + "0"));
                }
                nextMod = (nextMod + 1) % N;
                if (!visit[nextMod]) {
                    visit[nextMod] = true;
                    q.add(new Node(nextMod, now.str + "1"));
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int mod;
        String str;
        public Node(int mod, String str) {
            this.mod = mod;
            this.str = str;
        }
    }
}
