package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/24568
 */
public class math_24568_cupcakeParty {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.parseInt(br.readLine()) * 8 + Integer.parseInt(br.readLine()) * 3 - 28  + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
