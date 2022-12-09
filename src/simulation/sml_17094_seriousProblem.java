package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17094
 */
public class sml_17094_seriousProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int twoCnt = (int) br.readLine().chars()
                        .mapToObj(ch -> (char) ch)
                        .filter(c -> c == '2')
                        .count();
        if (twoCnt == N - twoCnt) {
            bw.write("yee");
        } else if (twoCnt > N - twoCnt) {
            bw.write("2");
        } else {
            bw.write("e");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
