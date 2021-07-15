package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2660
 * 2. 풀이
 *  - 문제 말이 복잡해보이지만 실질적으로, 각 노드에서 다른 노드까지 가는 가장 긴 거리를 구하는 문제
 *  - 전체 노드에서 다른 전체 노드로 이동하는 거리를 알아야 하기 때문에, 플로이드 와샬 알고리즘 사용
 *   > 플로이드-와샬로 각 노드간의 최소 이동 거리를 모두 구해놓음
 *   > 각 노드에서 최소 이동 거리 중 최장거리가 점수
 *   > 최종적으로 가장 작은 점수와 해당 점수인 유저들을 출력
 */
public class bfs_02660_president {

    static final int INF = 987654321;

    static int N;
    static int[][] map;

    static void floyd() {
        for(int k = 1; k <= N; k++) { // 거쳐가는 노드
            for(int i = 1; i <= N; i++) { // 출발 노드
                for(int j = 1; j <= N; j++) { // 도착 노드
                    if(map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N +1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = INF;
            }
        }

        String tmp = "";
        StringTokenizer st;
        while(!(tmp = br.readLine()).equals("-1 -1")) {
            st = new StringTokenizer(tmp);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        floyd();

        int[] maxArr = new int[N + 1];
        int max = INF;
        List<Integer> members = new ArrayList<>();
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                maxArr[i] = Math.max(maxArr[i], map[i][j]);
        for(int i = 1; i <= N; i++)
            max = Math.min(max, maxArr[i]);

        for(int i = 1; i <= N; i++)
            if(maxArr[i] == max) members.add(i);

        bw.write(String.format("%d %d\n", max, members.size()));
        for(Integer member : members)
            bw.write(member + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}
