package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2997
 */
public class sml_2997_fourthNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        if (arr[1] - arr[0] == arr[2] - arr[1]) {
            bw.write(arr[2] + (arr[1] - arr[0]) + "");
        } else {
            int gap = (arr[2] - arr[0]) / 3;
            bw.write((arr[2] - arr[1] > arr[1] - arr[0] ? arr[1] + gap : arr[0] + gap) + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
