package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17350
 */
public class sml_17350_secondBaseballerName {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        boolean contains = IntStream.range(0, N)
                        .mapToObj(i -> {
                            try {
                                return br.readLine();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .anyMatch(word -> word.equals("anj"));
        bw.write(contains ? "뭐야;" : "뭐야?");
        bw.flush();
        bw.close();
        br.close();
    }
}
