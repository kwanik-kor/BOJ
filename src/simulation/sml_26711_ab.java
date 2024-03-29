package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26711
 */
public class sml_26711_ab {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(new BigInteger(br.readLine()).add(new BigInteger(br.readLine())).toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
