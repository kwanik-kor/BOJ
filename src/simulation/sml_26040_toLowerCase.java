package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26040
 */
public class sml_26040_toLowerCase {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        Set<Character> targets = Arrays.stream(br.readLine().split(" "))
                        .map(a -> a.charAt(0))
                        .collect(Collectors.toSet());

        for (int i = 0, n = line.length(); i < n; i++) {
            if (targets.contains(line.charAt(i))) {
                bw.write(Character.toLowerCase(line.charAt(i)));
            } else {
                bw.write(line.charAt(i));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
