package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/14714
 * 2. 풀이
 *  - 각 차례에 대해 순차적으로 visit 처리를 통해 두 지목점이 같아지는지 체크하면됨
 */
public class bfs_14714_redGinsengGame {

    static int N, A, B, dA, dB;
    static boolean[][][] visit;

    static int solve() {
        visit[A][B][0] = true;

        Queue<Game> q = new LinkedList<>();
        q.add(new Game(A, B, 0, 1));
        while(!q.isEmpty()) {
            Game now = q.poll();
            if(now.a == now.b)
                return now.n;

            if(now.turn == 1) {
                int[] next = getNextNode(now.a, dA);
                for(int i = 0; i < 2; i++) {
                    if(!visit[next[i]][now.b][0]) {
                        visit[next[i]][now.b][0] = true;
                        q.add(new Game(next[i], now.b, now.n + 1, 2));
                    }
                }
            } else {
                int[] next = getNextNode(now.b, dB);
                for(int i = 0; i < 2; i++) {
                    if(!visit[now.a][next[i]][1]) {
                        visit[now.a][next[i]][1] = true;
                        q.add(new Game(now.a, next[i], now.n + 1, 1));
                    }
                }
            }
        }

        return -1;
    }

    static int[] getNextNode(int n, int val) {
        int[] ret = new int[2];
        ret[0] = (n + N - val) % N;
        ret[1] = (n + val) % N;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken()) - 1;
        B = Integer.parseInt(st.nextToken()) - 1;
        dA = Integer.parseInt(st.nextToken());
        dB = Integer.parseInt(st.nextToken());

        visit = new boolean[N][N][2];

        int ans = solve();
        bw.write(ans == -1? "Evil Galazy" : (ans + ""));
        bw.flush();
        bw.close();
        br.close();
    }

    static class Game {
        int a;
        int b;
        int n;
        int turn;
        public Game(int a, int b, int n, int turn) {
            this.a = a;
            this.b = b;
            this.n = n;
            this.turn = turn;
        }
    }
}
