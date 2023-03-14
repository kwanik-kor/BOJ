package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/15969
 */
public class sml_15969_happiness {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void solution() throws Exception {
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = 1001;
        int max = -1;

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        System.out.println(max - min);
    }

    public static void main(String[] args) throws Exception {
        new sml_15969_happiness().solution();
    }

}
