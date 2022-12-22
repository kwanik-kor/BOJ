package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26530
 */
public class sml_26530_shipping {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int cnt = Integer.parseInt(br.readLine());
            double tot = 0d;
            while (cnt-- > 0) {
                String[] arr = br.readLine().split(" ");
                tot += Double.parseDouble(arr[1]) * Double.parseDouble(arr[2]);
            }
            bw.write(String.format("$%.2f\n", tot));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
