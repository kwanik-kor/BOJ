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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/18188
 * 2. 풀이
 *  - BFS로 시뮬레이션을 구현하면 되는 문제
 *  - 크게 어려울 것은 없는 것으로 보이며, 각 지정된 움직임을 어떻게 효율적으로 설정해줄 것인가가 핵심
 */
public class bfs_18188_daosDate {

    static final char WALL = '@', DAO = 'D', DIZNI = 'Z', PLAIN = '.';
    static final String DIRECTION = "WDSA";

    static int H, W, N;
    static String path;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] order;
    static char[][] map;

    static Node dao;

    static boolean search() {
        int idx = 0;

        Queue<Node> q = new LinkedList<Node>();
        q.add(dao);
        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                Node now = q.poll();
                for(int dir = 0; dir < 2; dir++) {
                    int ny = now.y + dy[order[idx][dir]];
                    int nx = now.x + dx[order[idx][dir]];
                    if(outOfRange(ny, nx)) continue;
                    if(map[ny][nx] == DIZNI) {
                        path = now.path + DIRECTION.charAt(order[idx][dir]);
                        return true;
                    }

                    q.add(new Node(ny, nx, now.path + DIRECTION.charAt(order[idx][dir])));
                }
            }

            idx++;
            if(idx >= N)
                break;
        }

        return false;
    }

    static boolean outOfRange(int y, int x) {
        return y < 0 || x < 0 || H <= y || W <= x || map[y][x] == WALL;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        for(int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < W; j++) {
                if(map[i][j] == DAO) {
                    dao = new Node(i, j, "");
                    map[i][j] = PLAIN;
                }
            }
        }

        N = Integer.parseInt(br.readLine());
        order = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++) {
                order[i][j] = DIRECTION.indexOf(st.nextToken().charAt(0));
            }
        }

        boolean ans = search();

        bw.write(ans ? ("YES\n" + path): "NO");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int y, x;
        String path;
        public Node(int y, int x, String path) {
            this.y = y;
            this.x = x;
            this.path = path;
        }
    }
}
