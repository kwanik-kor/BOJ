package floyd;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1602
 * 2. 풀이
 *  - 플로이드 - 와샬 알고리즘에서 중간 노드를 선택하는 방법을 생각해 볼 수 있는 문제
 */
public class floyd_01602_fugitiveMonkey {

    static final int INF = 987654321;

    static int N, M, Q;
    static int[][] dog, map;
    static Dog[] dogs;

    static void floyd() {
        for(int k = 0; k < N; k++) {
            Dog m = dogs[k];

            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    int cost = Math.max(m.time, dog[i][j]);
                    int dist = (map[i][m.n] - dog[i][m.n]) + (map[m.n][j] - dog[m.n][j]) + cost;
                    if(dist < map[i][j]) {
                        map[i][j] = dist;
                        dog[i][j] = cost;
                    }
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
        Q = Integer.parseInt(st.nextToken());

        dogs = new Dog[N];
        dog = new int[N + 1][N + 1];
        map = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int time = Integer.parseInt(st.nextToken());
            dog[i][i] = time;
            dogs[i - 1] = new Dog(i, time);
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                map[i][j] = INF;
                dog[i][j] = Math.max(dog[i][i], dog[j][j]);
            }
        }

        for(int i = 1; i <= N; i++) {
            map[i][i] = dog[i][i];
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 멍멍이에 대한 가중치를 미리 전부 다 더해둠
            int dogCost = Math.max(dog[a][a], dog[b][b]);
            map[a][b] = c + dogCost;
            map[b][a] = c + dogCost;
        }

        Arrays.sort(dogs, (a, b) -> a.time - b.time);
        // ↑ Input End ↑

        floyd();

        while(Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(map[a][b] >= INF? "-1\n" : (map[a][b] + "\n"));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Dog {
        int n;
        int time;

        public Dog(int n, int time) {
            this.n = n;
            this.time = time;
        }
    }
}
