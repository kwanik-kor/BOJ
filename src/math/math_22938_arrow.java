package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/22938
 */
public class math_22938_arrow {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Long[] a = toArray(br.readLine());
        Long[] b = toArray(br.readLine());
        long tot = (a[2] + b[2]) * (a[2] + b[2]);
        long dist = (long) Math.pow(b[1] - a[1], 2) + (long) Math.pow(b[0] - a[0], 2);

        if (tot > dist) bw.write("YES");
        else bw.write("NO");

        bw.flush();
        bw.close();
        br.close();
    }

    static Long[] toArray(String line) {
        return Arrays.stream(line.split(" "))
                .map(Long::parseLong)
                .toArray(Long[]::new);
    }
}
