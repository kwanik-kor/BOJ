package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/24196
 */
public class sml_24196_gomdaord {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = br.readLine().toCharArray();
        int idx = 0;

        do {
            bw.write(arr[idx]);
            idx += arr[idx] - 'A' + 1;
        } while (idx < arr.length);

        bw.flush();
        bw.close();
        br.close();
    }
}
