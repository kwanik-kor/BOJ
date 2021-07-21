package dp;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16502
 * 2. 풀이
 *  - 각 노드(매장)에서 다른 노드로 가는 간선을 적절히 저장해둔다면 어려움 없이 풀 수 있는 문제
 *  - 단순히 이전 값을 사용해야 한다는 의미에서 문제가 DP로 분류된듯 하나, 
 *   실질적으로는 수학 카테고리만 있었어도 됐지 않을까... 싶은 문제 
 */
public class dp_16502_findHer {

    static int N, M;
    static double[] dp;
    static Map<Integer, List<Edge>> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edges = new HashMap<>();
        dp = new double[4];
        for(int i = 0; i < 4; i++) {
            edges.put(i, new ArrayList<>());
            dp[i] = 25d;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = st.nextToken().charAt(0) - 'A';
            int end = st.nextToken().charAt(0) - 'A';
            double cost = Double.parseDouble(st.nextToken());
            edges.get(start).add(new Edge(end, cost));
        }

        while(N-- > 0) {
            double[] tempArr = new double[4];


            for(int i = 0; i < 4; i++) {
                for(Edge next : edges.get(i)) {
                    tempArr[next.n] += dp[i] * next.per;
                }
            }

            System.arraycopy(tempArr, 0, dp, 0, 4);
        }

        for(int i = 0; i < 4; i++) {
            bw.write(String.format("%.2f\n", dp[i]));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Edge {
        int n;
        double per;
        public Edge(int n, double per) {
            this.n = n;
            this.per = per;
        }
    }
}
