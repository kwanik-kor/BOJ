package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26545
 */
public class sml_26545_mathematics {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int tot = IntStream.range(0, N)
                .map((idx) -> {
                    try {
                        return Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .sum();
        bw.write(tot + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
