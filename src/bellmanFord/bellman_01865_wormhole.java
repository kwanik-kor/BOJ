package bellmanFord;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1865
 * 2. 풀이
 *  - 벨만 - 포드 알고리즘의 기본형 중 하나인 문제
 */
public class bellman_01865_wormhole {

    static final int INF = 987654321;

    static int N, M, W;
    static int[] arr;
    static List<Node> nodes;

    static boolean solve() {
        boolean isShortened = false;

        for(int i = 1; i <= N; i++) {
            isShortened = false;
            for(Node node : nodes) {
                if(arr[node.start] + node.cost < arr[node.end]) {
                    arr[node.end] = arr[node.start] + node.cost;
                    isShortened = true;
                    if(i == N) {
                        return true;
                    }
                }
            }
            if(!isShortened)
                break;
        }
        // git test
        return isShortened;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            nodes = new ArrayList<>();
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                nodes.add(new Node(a, b, c));
                nodes.add(new Node(b, a, c));
            }

            for(int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                nodes.add(new Node(a, b, -c));
            }

            arr = new int[N + 1];
            Arrays.fill(arr, INF);
            arr[1] = 0;

            bw.write(solve()? "YES\n" : "NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int start;
        int end;
        int cost;
        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
