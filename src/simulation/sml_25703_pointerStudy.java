package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25703
 */
public class sml_25703_pointerStudy {

    static final String FORMAT_BASE = "int %sptr%d = &ptr;\n";
    static final String FORMAT = "int %sptr%d = &ptr%d;\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        bw.write("int a;\n");
        bw.write("int *ptr = &a;\n");

        if (N >= 2) {
            for (int i = 2; i <= N; i++) {
                bw.write(createLine(i));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static String createLine(int cnt) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, cnt)
                .forEach(idx -> sb.append("*"));
        if (cnt == 2) {
            return String.format(FORMAT_BASE, sb.toString(), cnt);
        }
        return String.format(FORMAT, sb.toString(), cnt, cnt - 1);
    }

}
