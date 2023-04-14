package simulation;

import java.io.*;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/23530
 */
public class sml_23530_notAplusB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            bw.write("1\n");
        }
        bw.close();
        br.close();
    }

}
