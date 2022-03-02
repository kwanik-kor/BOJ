package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2501
 */
public class sml_02501_divisor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean find = false;
        int k = 0;
        for(int n = 1; n <= N; n++) {
            if(N % n == 0) {
                k++;
                if(k == K) {
                    find = true;
                    bw.write(n + "");
                    break;
                }
            }
        }
        if(!find) bw.write("0");
        bw.flush();
        bw.close();
        br.close();
    }
}
