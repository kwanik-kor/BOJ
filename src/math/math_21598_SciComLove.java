package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/21598
 */
public class math_21598_SciComLove {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        IntStream.range(0, Integer.parseInt(br.readLine()))
            .forEach(e -> {
                try {
                    bw.write("SciComLove\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

        bw.flush();
        bw.close();
        br.close();
    }

}
