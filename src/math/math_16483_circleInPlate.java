package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/16483
 */
public class math_16483_circleInPlate {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        float t = Float.parseFloat(br.readLine()) / 2;
        bw.write((int)(t * t + 0.5f) + "");
        bw.close();
        br.close();
    }
}
