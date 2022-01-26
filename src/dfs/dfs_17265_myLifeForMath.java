package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/17265
 * 2. 풀이
 *  - 이게 왜 dfs..? 억지로 dfs로 풀어봄...
 */
public class dfs_17265_myLifeForMath {

    static int N;

    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    static int[] dy = {0, 1};
    static int[] dx = {1, 0};

    static char[][] map;

    static void dfs(int y, int x, Character calc, int tot) {
        if(y == N - 1 && x == N - 1) {
            min = Math.min(min, tot);
            max = Math.max(max, tot);
            return;
        }

        for(int dir = 0; dir < 2; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(isOutBound(ny, nx)) continue;

            if(isNumber(map[ny][nx])) {
                dfs(ny, nx, null, calc(tot, map[ny][nx] - '0', calc));
            } else {
                dfs(ny, nx, map[ny][nx], tot);
            }

        }
    }

    static int calc(int a, int b, char calc) {
        switch(calc) {
            case '+': return a + b;
            case '-': return a - b;
            default: return a * b;
        }
    }

    static boolean isOutBound(int y, int x) {
        return y < 0 || x < 0 || N <= y || N <= x;
    }

    static boolean isNumber(char c) {
        return '0' <= c && c <= '5';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new char[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0, 0, null, map[0][0] - '0');

        bw.write(max + " " + min);
        bw.flush();
        bw.close();
        br.close();
    }
}
