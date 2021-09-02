package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/10484
 * 2. 풀이
 *  - 이동했던 경로의 역방향으로 이동할 수 있다는 조건이 있었다.
 *  - 그렇다 하더라도, 그냥 단일방향으로 진행했을 때 이미 방문한 노드가 더 cost가 적었다면 이를 사용하면 되는게 아닌가..?
 *    - 반례를 찾아보자!
 */
public class bfs_10484_erraticAnts {

    static final String DIRECTION = "NESW";
    static final int N = 121;
    static final int INF = 987654321;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static Map<Integer, Set<Integer>> edges;
    static int end;

    static int solve() {
        Integer start = 60 * N + 60;

        Set<Integer> visit = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit.add(start);

        int ret = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                Integer now = q.poll();
                if(now == end)
                    return ret;
                for(Integer next : edges.get(now)) {
                    if(visit.add(next))
                        q.add(next);
                }
            }
            ret++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            edges = new HashMap<>();
            br.readLine();
            int s = Integer.parseInt(br.readLine());
            int y = 60, x = 60;

            while(s-- > 0) {
                int old = y * N + x;
                int dir = DIRECTION.indexOf(br.readLine().charAt(0));
                y += dy[dir];
                x += dx[dir];
                int nw = y * N + x;
                getNode(old).add(nw);
                getNode(nw).add(old);
            }

            end = y  * N + x;
            bw.write(solve() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static Set<Integer> getNode(int n) {
        Set<Integer> ret = edges.get(n);
        if(ret == null) {
            ret = new HashSet<>();
            edges.put(n, ret);
        }
        return ret;
    }

}
