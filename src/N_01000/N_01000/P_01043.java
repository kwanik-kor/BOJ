package N_01000.N_01000;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Collections.sort;

public class P_01043 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] parents;

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parents[b] = a;
        }
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowCnt = Integer.parseInt(st.nextToken());
        int[] truth = new int[knowCnt];
        for (int i = 0; i < knowCnt; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer>[] parties = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            parties[i] = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                parties[i].add(Integer.parseInt(st.nextToken()));
            }

            sort(parties[i]);
            int first = parties[i].get(0);
            for (int j = 1; j < n; j++) {
                union(first, parties[i].get(j));
            }
        }

        int possible = 0;
        for (int i = 0; i < M; i++) {
            int representative = parties[i].get(0);
            boolean flag = true;

            for (int j = 0; j < knowCnt; j++) {
                if (find(representative) == find(truth[j])) {
                    flag = false;
                    break;
                }
            }

            if (flag) possible++;
        }

        bw.write(possible + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
