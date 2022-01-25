package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/17073
 * 2. 풀이
 *  - 자식 노드에게 동일한 확률로 빗물이 떨어진다면, 결과적으로 리프 노드에 도달했을 때 리프노드들의 기댓값의 합은 W이다.
 *   - 다시 말해, W를 리프노드의 개수로 나눠주면 해결
 */
public class dfs_17073_raindropOnTree {

    static int N;
    static double W;

    static int[] leaf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Double.parseDouble(st.nextToken());

        leaf = new int[N + 1];
        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            leaf[a]++;
            leaf[b]++;
        }

        double leafCnt = 0;
        for(int i = 2; i <= N; i++) {
            if(leaf[i] == 1)
                leafCnt++;
        }

        bw.write(W / leafCnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
