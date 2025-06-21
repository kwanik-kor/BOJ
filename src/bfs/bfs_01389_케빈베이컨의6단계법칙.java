package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bfs_01389_케빈베이컨의6단계법칙 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int MAX = 2000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        final int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], MAX);
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            dist[s][e] = 1;
            dist[e][s] = 1;
        }

        // floyd
        for (int mid = 1; mid <= n; mid++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (dist[s][e] > dist[s][mid] + dist[mid][e]) {
                        dist[s][e] = dist[s][mid] + dist[mid][e];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int node = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] != MAX) {
                    sum += dist[i][j];
                }
            }

            if (min > sum) {
                node = i;
            }
            min = Math.min(min, sum);
        }

        bw.write(node + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
