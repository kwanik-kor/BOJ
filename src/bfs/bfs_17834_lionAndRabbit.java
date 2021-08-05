package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/17834
 * 2. 풀이
 *  - 사자와 토끼가 서로 만날 수 없다는 것은, 그래프의 정점들을 이분그래프화 할 수 있느냐는 말이다.
 *  - 즉, 그래프를 두 가지 색깔로 나눠 칠했을 때, 정확하게 나눠서 칠해진다면 둘이 영원히 만나지 않는
 *    경로가 존재함을 의미한다.
 *   >> 이 때, Red를 토끼 Blue를 사자로 봤을 때, RED_개수 * BLUE_개수 * 2를 하게 되면
 *     만나지 않는 쌍의 개수가 만들어진다.
 */
public class bfs_17834_lionAndRabbit {

    static final int RED = 1, BLUE = -1;

    static int N, M;
    static long red = 0L;
    static long blue = 0L;
    static boolean canDivide = true;

    static int[] visit;
    static Map<Integer, Set<Integer>> map;

    static void bfs() {
        visit = new int[N + 1];
        visit[1] = RED;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        red++;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(Integer next : map.get(now)) {
                if(visit[next] == 0) {
                    q.add(next);
                    visit[next] = visit[now] * -1;
                    if(visit[now] == RED) {
                        blue++;
                    } else {
                        red++;
                    }
                } else if(visit[next] + visit[now] != 0) {
                    canDivide = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        bfs();

        if(canDivide) {
            bw.write((red * blue * 2) + "");
        } else {
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
