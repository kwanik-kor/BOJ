package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1430
 * 2. 풀이
 *  - 적의 위치에서 R범위 내에 있는 타워로 순차적으로 이동하며, 연결가능한 전체 타워의 개수를 취합한다.
 *    - 이 때, n 번째 타워라면 D * (2 ^ n)을 더해주면 됨~!
 *     > 단 n은 0부터 시작해야 하는 것이 적을 공격할 때는 에너지가 반감되지 않고 그대로 전달되기 때문이다.
 */
public class bfs_01430_attack {

    static int N, R, X, Y;
    static double D;
    static List<Integer>[] towers;
    static boolean[][] visit;

    static double bfs() {
        double ret = 0d;

        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(Y, X, 0));
        visit[Y][X] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            for(int ny = now.y - R; ny <= now.y + R; ny++) {
                if(ny < 0) ny = 0;
                if(1000 < ny) break;

                for(Integer nx : towers[ny]) {
                    if(visit[ny][nx]) continue;

                    if(getDist(ny, nx, now.y, now.x) <= R) {
                        ret += D / Math.pow(2, now.dist);
                        visit[ny][nx] = true;
                        q.add(new Node(ny, nx, now.dist + 1));
                    }
                }
            }
        }


        return ret;
    }

    static boolean outOfRange(int val) {
        return val < 0 || 1000 < val;
    }

    static double getDist(int y1, int x1, int y2, int x2) {
        return Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        D = Double.parseDouble(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        towers = new List[1001];
        visit = new boolean[1001][1001];
        for(int i = 0; i <= 1000; i++) {
            towers[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            towers[y].add(x);
        }

        bw.write(bfs() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int y, x, dist;
        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}
