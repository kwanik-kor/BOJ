package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/8371
 */
public class sml_08371_dyslexia {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        char[] line1 = br.readLine().toCharArray();
        char[] line2 = br.readLine().toCharArray();
        int cnt = (int) IntStream.range(0, N)
                        .filter(idx -> line1[idx] != line2[idx])
                        .count();
        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
