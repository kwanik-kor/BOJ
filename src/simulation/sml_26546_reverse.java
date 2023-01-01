package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26546
 */
public class sml_26546_reverse {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] arr = br.readLine().split(" ");
            bw.write(arr[0].substring(0, Integer.parseInt(arr[1])) + arr[0].substring(Integer.parseInt(arr[2])) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
