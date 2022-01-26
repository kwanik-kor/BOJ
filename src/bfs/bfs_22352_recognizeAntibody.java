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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/22352
 * 2. 풀이
 *  - 기존 격자의 배치와 새로운 격자의 배치를 3차원 배열로 같이 저장해둠.
 *  - 기존 격자 배치의 영역별로 bfs 탐색을 진행하면서,
 *    새로운 격자판에서 동일한 영역내에 다른 값이 있는지 체크함
 *  - 이 때, bfs 탐색을 시작할 당시 기존 격자와 새로운 격자의 값이 다르다면
 *    해당 영역은 확정적으로 백신이 투약된 위치라고 볼 수 있음.
 *     > 단, 값이 다른게 2개 이상 있다면 이는 잘못된 것이기 때문에 바로 break
 */
public class bfs_22352_recognizeAntibody {

    static int N, M;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static boolean[][] visit;
    static int[][][] map;

    static boolean searchArea(int y, int x) {
        boolean ret = true;

        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(y, x));
        visit[y][x] = true;

        int origin = map[0][y][x];
        int flag = map[1][y][x];
        while(!q.isEmpty()) {
            Node now = q.poll();
            for(int dir = 0; dir <4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(isOutBound(ny, nx) || visit[ny][nx] || map[0][ny][nx] != origin) continue;
                if(map[1][ny][nx] != flag) return false;
                visit[ny][nx] = true;
                q.add(new Node(ny, nx));
            }
        }

        return ret;
    }

    static boolean isOutBound(int y, int x) {
        return y < 0 || x < 0 || N <= y || M <= x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[2][N][M];
        visit = new boolean[N][M];
        for(int t = 0; t < 2; t++) {
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    map[t][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int differentCnt = 0;
        boolean ans = true;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!ans) break;
                if(visit[i][j]) continue;
                if(map[0][i][j] != map[1][i][j]) {
                    if(differentCnt == 1) {
                        ans = false;
                        break;
                    }
                    differentCnt++;
                    ans = searchArea(i, j);
                }
            }
            if(!ans) break;
        }

        bw.write(ans ? "YES" : "NO");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int y, x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
