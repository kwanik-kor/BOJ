package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/11060
 * 2. 풀이
 *  - 단순 BFS 로 처리 가능함! 별도 풀이 불필요
 */
public class bfs_11060_jumpjump {

    static int N;
    static int[] maze;

    static int solve() {
        int ret = 0;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[N];
        q.add(0);
        visit[0] = true;

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                int now = q.poll();
                if(now == N - 1)
                    return ret;

                int mount = maze[now];
                for(int i = 1; i <= mount; i++) {
                    int next = now + i;
                    if(N <= next || visit[next] || maze[next] == 0) continue;
                    q.add(next);
                    visit[next] = true;
                }
            }

            ret++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        maze = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solve() + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
