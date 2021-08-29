package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/12153
 * 2. 풀이
 *  - 다음 노드를 탐색하는 조건만 잘 설정해주면 시간내에 풀이 가능
 */
public class bfs_12153_counterCulture {

    static final int INF = 10000000;
    static int N;
    static boolean[] visit;

    static int solve() {
        int ret = 1;

        visit = new boolean[INF];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int now = q.poll();
                if(now == N)
                    return ret;

                int next_1 = now + 1;
                if(!visited(next_1)) {
                    visit[next_1] = true;
                    q.add(next_1);
                }
                int next_2 = reverseNum(now);
                if(!visited(next_2)) {
                    visit[next_2] = true;
                    q.add(next_2);
                }
            }
            ret++;
        }

        return ret;
    }

    static int reverseNum(int n) {
        StringBuffer sb = new StringBuffer(String.valueOf(n));
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }

    static boolean visited(int n) {
        return visit[n] || INF <= n || N < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            bw.write(String.format("Case #%d: %d\n", t, solve()));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
