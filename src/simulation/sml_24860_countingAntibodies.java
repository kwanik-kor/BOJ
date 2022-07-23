package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/24860
 */
public class sml_24860_countingAntibodies {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long v1 = Long.parseLong(st.nextToken());
        long j1 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long v2 = Long.parseLong(st.nextToken());
        long j2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long v = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());
        long j = Long.parseLong(st.nextToken());

        bw.write(v * j * d * (v1 * j1 + v2 * j2) + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
