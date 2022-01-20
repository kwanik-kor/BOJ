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
import java.util.stream.IntStream;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/19231
 * 2. 풀이
 *  - 정보를 전달받은 사람들은 계속해서 확장하여 정보를 전달할 수 있다는 문제였다.
 *    - 단 n번째 날짜의 경우 K(거리) * n 만큼 정보를 전달할 수 있기에, 날짜별로 최종 도착지점을 큐에 갱신시켜줘야 한다.
 *    - 이에 큐 내부적으로 루프를 돌면서, 진행할 수 있는 거리가 0이 되지 않으면 다시 size를 키워주고
 *      더 이상 진행할 수 없는 도착한 노드들은 모아두었다가 최종적으로 큐에 다시 삽입해준다.
 */
public class bfs_19231_birmingham {

    static int N, M, Q, K;
    static int[] house;

    static List<Integer>[] adj;

    static void solve(List<Node> start) {
        int day = 1;

        Queue<Node> q = new LinkedList<Node>(start);

        while(!q.isEmpty()) {
            int size = q.size();

            List<Node> arrived = new ArrayList<>();

            while(size-- > 0) {
                Node now = q.poll();
                if(now.step == 0) {
                    arrived.add(new Node(now.n, (day + 1) * K));
                    continue;
                }
                for(Integer next : adj[now.n]) {
                    if(house[next] != -1) continue;

                    house[next] = day;
                    size++;

                    q.add(new Node(next, now.step - 1));
                }
            }

            day++;
            q.addAll(arrived);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        house = new int[N + 1];
        adj = new List[N + 1];
        IntStream.rangeClosed(1, N)
                .forEach(idx -> {
                    house[idx] = -1;
                    adj[idx] = new ArrayList<>();
                });

        // start houses
        st = new StringTokenizer(br.readLine());
        List<Node> start = new ArrayList<>();
        for(int i = 0; i < Q; i++) {
            int n = Integer.parseInt(st.nextToken());
            house[n] = 0;
            start.add(new Node(n, K));
        }

        // roads
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        solve(start);

        for(int i = 1; i <= N; i++) {
            bw.write(house[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int n, step;
        public Node(int n, int step) {
            this.n = n;
            this.step = step;
        }
    }
}
