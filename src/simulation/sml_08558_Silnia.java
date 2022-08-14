package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/8558
 */
public class sml_08558_Silnia {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int result = 1;
        for (int i = 2; i <= N; i++) {
            if (result == 0) break;
            result = (result * i) % 10;
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
