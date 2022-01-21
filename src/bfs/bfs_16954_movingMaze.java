package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16954
 * 2. 풀이
 *  - 시간이 지남에 따라 미로가 한 칸 씩 아래로 내려오기 때문에, 결과적으로 8초 부터는 모든 벽이 없음을 알 수 있음
 *  - 이를 배열로 처리해, 시간 별로 욱제가 있을 수 있는 위치를 체크한다.
 *  - 단, 욱제가 첫번째 행에 도착한다면 이미 벽은 없다고 판단할 수 있기에 굳이 가장 우측 상단에 도착하지 않아도 루프를 종료할 수 있음
 */
public class bfs_16954_movingMaze {

    static final int N = 8;
    static final char WALL = '#';

    static int wallCnt = 0;
    static int[] dy = {0, -1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dx = {0, 0, 1, 0, -1 ,1, -1, 1, -1};

    static char[][] map = new char[8][8];
    static boolean[][][] visit = new boolean[9][8][8];

    static boolean solve() {
        Queue<Node> q  = new LinkedList<>();
        q.add(new Node(0, 7, 0));
        visit[0][7][0] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.y == 0)
                return true;

            for(int dir = 0; dir < 9; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                int nt = Math.min(now.t + 1, 8);
                if(isOutBound(ny, nx)) continue;
                if(0 <= ny - now.t && map[ny - now.t][nx] == WALL) continue;
                if(0 <= ny - now.t - 1 && map[ny - now.t - 1][nx] == WALL) continue;

                if(!visit[nt][ny][nx]) {
                    visit[nt][ny][nx] = true;
                    q.add(new Node(nt, ny, nx));
                }
            }
        }

        return false;
    }

    static boolean isOutBound(int y, int x) {
        return y < 0 || x < 0 || N <= y || N <= x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        boolean ans = solve();

        bw.write(ans? "1" : "0");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int t, y, x;
        public Node(int t, int y, int x) {
            this.t = t;
            this.y = y;
            this.x = x;
        }
    }

}
