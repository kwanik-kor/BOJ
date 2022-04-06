package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2547
 */
public class sml_2547_candyTeacher {

    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            br.readLine();
            int N = Integer.parseInt(br.readLine());
            long sum = 0L;
            for(int i = 0; i < N; i++) {
                sum = (sum + Long.parseLong(br.readLine())) % N;
            }
            bw.write(sum % N == 0? "YES\n" : "NO\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
