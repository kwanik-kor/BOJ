package simulation;

import java.io.*;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/10820
 */
public class sml_10820_analyzeString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = "";

        int[] cnt = new int[4];
        while ((line = br.readLine()) != null && !line.equals("")) {
            char[] arr = line.toCharArray();

            cnt = new int[4];
            for (int i = 0, n = arr.length; i < n; i++) {
                if (arr[i] == ' ') {
                    cnt[3]++;
                } else if ('0' <= arr[i] && arr[i] <= '9') {
                    cnt[2]++;
                } else if ('a' <= arr[i] && arr[i] <= 'z') {
                    cnt[0]++;
                } else {
                    cnt[1]++;
                }
            }

            bw.write(String.format("%d %d %d %d\n", cnt[0], cnt[1], cnt[2], cnt[3]));
        }
        bw.close();
        br.close();
    }

}
