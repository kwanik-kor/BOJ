package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/10262
 */
public class sml_10262_diceGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] a = new int[4];
        int[] b = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++)
            a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++)
            b[i] = Integer.parseInt(st.nextToken());
        int sumA = a[0] + a[1] + a[2] + a[3];
        int sumB = b[0] + b[1] + b[2] + b[3];
        if(sumA > sumB) bw.write("Gunnar");
        else if (sumA < sumB) bw.write("Emma");
        else bw.write("Tie");
        bw.flush();
        bw.close();
        br.close();
    }
}
