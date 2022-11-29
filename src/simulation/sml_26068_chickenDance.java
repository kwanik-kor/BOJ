package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26068
 */
public class sml_26068_chickenDance {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write((int) IntStream.range(0, Integer.parseInt(br.readLine()))
                        .map((idx) -> {
                            try {
                                return Integer.parseInt(br.readLine().split("-")[1]);
                            } catch (IOException e) {
                                return 91;
                            }
                        })
                        .filter(day -> day <= 90)
                        .count()
                + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
