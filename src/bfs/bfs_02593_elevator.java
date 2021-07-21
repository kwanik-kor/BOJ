package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2593
 * 2. 풀이
 *  - 층수 중심으로 움직여야 할 것으로 보이지만 실질적으로는 엘리베이터 기준으로 움직이면 됨
 *  - 출발 층수에서 움직일 수 있는 엘리베이터를 기준으로 엘리베이터를 환승해가면서 도착 지점에
 *    제일 빠르게 도착할 수있는 거리를 BFS로 계산한다.
 */
public class bfs_02593_elevator {

    static final int INF = 987654321;

    static int N, M, start, end;
    static int[] visit, dist;
    static Elevator[] elevators;

    static void bfs(Elevator e) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(e.num, 1));
        visit[e.num] = e.num;
        dist[e.num] = 1;

        while(!q.isEmpty()) {
            Point now = q.poll();

            if(elevators[now.n].canReach) continue;

            for(int i = 1; i <= M; i++) {
                if(now.n == i) continue;
                if(canTransfer(now.n, i)) {
                    if(now.dist + 1 < dist[i]) {
                        dist[i] = now.dist + 1;
                        visit[i] = now.n;
                        q.add(new Point(i, now.dist + 1));
                    }
                }
            }
        }
    }

    static boolean canTransfer(int a, int b) {
        if(elevators[a].start == elevators[b].start) return true;

        int tempStart = elevators[b].start;

        while(tempStart <= N) {
            if(elevators[a].start <= tempStart && (tempStart - elevators[a].start) % elevators[a].interval == 0)
                return true;
            tempStart += elevators[b].interval;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new int[M + 1];
        dist = new int[M + 1];
        elevators = new Elevator[M + 1];
        for(int i = 1; i <= M; i++) {
            visit[i] = -1;
            dist[i] = INF;

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            elevators[i] = new Elevator(i, x, y);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 엘리베이터가 도착점에 도달할 수 있는지 Setting
        List<Integer> endElev = new ArrayList<>();
        for(int i = 1; i <= M; i++) {
            Elevator elev = elevators[i];
            if(elev.start <= end && (end - elev.start) % elev.interval == 0) {
                elev.setCanReach(true);
                endElev.add(i);
            }
        }

        // 엘리베이터 별로 BFS 진행
        for(int i = 1; i <= M; i++) {
            Elevator elev = elevators[i];
            if(start < elev.start || (start  - elev.start) % elev.interval != 0) continue;
            if(elev.canReach) {
                bw.write(String.format("1\n%d", i));
                bw.flush();
                return;
            }
            bfs(elev);
        }

        int ans = INF;
        int fin = -1;
        for(Integer elev : endElev) {
            if(dist[elev] < ans) {
                ans = dist[elev];
                fin = elev;
            }
        }

        if(ans == INF || fin == -1) {
            bw.write("-1");
        } else {
            bw.write(ans + "\n");
            List<Integer> path = new ArrayList<>();
            while(true) {
                path.add(fin);
                if(fin == visit[fin]) break;
                fin = visit[fin];
            }
            for(int i = path.size() - 1; i >= 0; i--) {
                bw.write(path.get(i) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int n;
        int dist;
        public Point(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }
    }

    static class Elevator {
        int num;
        int start;
        int interval;
        boolean canReach;

        public Elevator(int num, int start, int interval) {
            this.num = num;
            this.start = start;
            this.interval = interval;
            this.canReach = false;
        }

        public void setCanReach(boolean canReach) {
            this.canReach = canReach;
        }
    }

}
