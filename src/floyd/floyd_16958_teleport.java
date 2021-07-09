package floyd;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16958
 * 2. 풀이
 *  - 플로이드 - 와샬..
 *  - 처음에는 모든 노드간 최소거리를 구할 때, 텔레포트 여부를 검사해서 시간초과가 남
 *   > 처음 노드 간 거리를 연산할 때, 텔레포트 여부를 파악해 최소거리를 만들어두니 통과
 */
public class floyd_16958_teleport {

    static int N, T;
    static boolean[] special;
    static Point[] nodes;
    static int[][] map;

    static void floyd() {
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][k] + map[k][j] < map[i][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        special = new boolean[N];
        nodes = new Point[N];
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            nodes[i] = new Point(y, x);
            special[i] = type == 1;
        }

        // 두 도시 간 거리 미리 게산
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                map[i][j] = Math.abs(nodes[i].y - nodes[j].y) + Math.abs(nodes[i].x - nodes[j].x);
                if(special[i] && special[j])
                    map[i][j] = Math.min(T, map[i][j]);
            }
        }

        floyd();

        int M = Integer.parseInt(br.readLine());
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            bw.write(map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
