package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26742
 */
public class sml_26742_skarpetki {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] line = br.readLine().toCharArray();
        int[] arr = new int[2];

        for (int i = 0, n = line.length; i < n; i++) {
            arr[line[i] == 'B' ? 0 : 1]++;
        }
        bw.write(arr[0] / 2 + arr[1] / 2 + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
