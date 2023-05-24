package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/28097
 */
public class sml_28097_phonix {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tot = 0;
        for (int i = 0; i < n; i++) {
            tot += Integer.parseInt(st.nextToken());
        }
        tot += (n - 1) * 8;

        bw.write(String.format("%d %d", tot / 24, tot % 24));
        bw.close();
        br.close();
    }

}
