package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2204
 */
public class sml_02204_dyslexia {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            List<String> words = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                words.add(br.readLine());
            }
            words.sort(String::compareToIgnoreCase);
            bw.write(words.get(0) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
