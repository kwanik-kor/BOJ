package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bfs_09347_fence {

    static int R, C;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[R + 2][C + 2];
            for(int i = 1; i <= R; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= C; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
