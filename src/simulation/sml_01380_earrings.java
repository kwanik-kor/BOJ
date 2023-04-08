package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1380
 */
public class sml_01380_earrings {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int scenario = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            String[] names = new String[N];
            for (int i = 0; i < N; i++) {
                names[i] = br.readLine();
            }

            Set<Integer> set = new HashSet<>();
            StringTokenizer st;
            for (int i = 0, n = 2 * N - 1; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                if (set.contains(a)) {
                    set.remove(a);
                } else {
                    set.add(a);
                }
            }

            for (Integer idx : set) {
                bw.write(String.format("%d %s\n", scenario, names[idx - 1]));
            }

            scenario++;
        }
        bw.close();
        br.close();
    }

}
