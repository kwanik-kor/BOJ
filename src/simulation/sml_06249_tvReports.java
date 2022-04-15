package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6249
 */
public class sml_06249_tvReports {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            int dollar = Integer.parseInt(br.readLine());
            if (dollar > h) {
                bw.write(String.format("BBTV: Dollar reached %d Oshloobs, A record!\n", dollar));
                h = dollar;
            } else if (dollar < p) {
                bw.write(String.format("NTV: Dollar dropped by %d Oshloobs\n", p - dollar));
            }
            p = dollar;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
