package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17010
 */
public class sml_17010_timeToDecompress {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] line = br.readLine().split(" ");
            for (int i = 0, n = Integer.parseInt(line[0]); i < n; i++) {
                bw.write(line[1]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
