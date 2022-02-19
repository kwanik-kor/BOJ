package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/24079
 */
public class math_24079_moving {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        int Y = Integer.parseInt(br.readLine());
        int Z = Integer.parseInt(br.readLine());

        bw.write(X + Y <= Z? "1" : "0");
        bw.flush();
        bw.close();
        br.close();
    }
}
