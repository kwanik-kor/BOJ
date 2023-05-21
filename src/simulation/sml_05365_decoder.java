package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5365
 */
public class sml_05365_decoder {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                bw.write(arr[0].charAt(0));
                continue;
            }

            String prev = arr[i - 1];
            String now = arr[i];
            if (prev.length() > now.length()) {
                bw.write(" ");
            } else {
                bw.write(now.charAt(prev.length() - 1));
            }
        }

        bw.close();
        br.close();
    }
}
