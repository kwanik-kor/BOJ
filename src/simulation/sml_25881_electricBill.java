package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25881
 */
public class sml_25881_electricBill {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int mount = Integer.parseInt(br.readLine());
            if (mount <= 1000) {
                bw.write(String.format("%d %d\n", mount, mount * N));
            } else {
                bw.write(String.format("%d %d\n", mount, 1000 * N + (mount - 1000) * A));
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
