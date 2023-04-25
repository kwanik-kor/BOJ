package simulation;

import java.io.*;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/27324
 */
public class sml_27324_sameNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        bw.write(line.charAt(0) == line.charAt(1) ? "1" : "0");
        bw.close();
        br.close();
    }

}
