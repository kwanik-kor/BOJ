package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/27310
 */
public class sml_27310_chinoShock {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = br.readLine().toCharArray();

        int n = arr.length;
        int colon = 0;
        int underbar = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == ':') colon++;
            else if (arr[i] == '_') underbar++;
        }

        bw.write(underbar * 5 + n + colon + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
