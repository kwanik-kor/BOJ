package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/27541
 */
public class sml_27541_lastLetter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        if (str.charAt(N - 1) == 'G') {
            bw.write(str.substring(0, N - 1));
        } else {
            bw.write(str + "G");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
