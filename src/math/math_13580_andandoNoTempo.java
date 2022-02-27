package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/13580
 */
public class math_13580_andandoNoTempo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for(int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[0]) bw.write("S");
        else if(arr[0] == arr[1] + arr[2] || arr[1] == arr[2] + arr[0] || arr[2] == arr[0] + arr[1]) bw.write("S");
        else bw.write("N");

        bw.flush();
        bw.close();
        br.close();
    }
}
