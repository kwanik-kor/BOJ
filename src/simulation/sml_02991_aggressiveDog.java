package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2991
 */
public class sml_02991_aggressiveDog {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(st.nextToken());
            boolean flagA = 0 < n % (A + B) && n % (A + B) <= A;
            boolean flagB = 0 < n % (C + D) && n % (C + D) <= C;
            bw.write((flagA? 1 : 0) + (flagB? 1 : 0) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
