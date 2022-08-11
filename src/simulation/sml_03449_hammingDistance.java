package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/3449
 */
public class sml_03449_hammingDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            char[] arr1 = br.readLine().toCharArray();
            char[] arr2 = br.readLine().toCharArray();

            int dist = 0;
            for (int i = 0, n = arr1.length; i < n; i++) {
                if (arr1[i] != arr2[i]) {
                    dist++;
                }
            }
            bw.write(String.format("Hamming distance is %d.\n", dist));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
