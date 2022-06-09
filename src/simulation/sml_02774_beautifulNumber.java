package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2774
 */
public class sml_02774_beautifulNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Set<Character> set = br.readLine().chars()
                    .mapToObj(e -> (char) e)
                    .collect(Collectors.toSet());
            bw.write(set.size() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
