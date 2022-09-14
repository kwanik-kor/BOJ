package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/8387
 */
public class sml_08387_dyslexia {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String line1 = br.readLine();
        String line2 = br.readLine();
        bw.write(
                ((int) IntStream.range(0, N)
                        .filter(idx -> line1.charAt(idx) == line2.charAt(idx))
                        .count()) + ""
        );
        bw.flush();
        bw.close();
        br.close();
    }
}
