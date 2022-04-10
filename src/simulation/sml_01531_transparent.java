package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1531
 */
public class sml_01531_transparent {
    static int N, M;
    static int[][] map = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            IntStream.rangeClosed(y1, y2).forEach(y -> {
                IntStream.rangeClosed(x1, x2).forEach(x -> {
                    map[y][x]++;
                });
            });
        }

        int cnt = 0;
        for(int i = 1; i <= 100; i++) {
            for(int j = 1; j <= 100; j++) {
                if (map[i][j] > M) {
                    cnt++;
                }
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
