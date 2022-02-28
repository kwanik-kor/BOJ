package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/23375
 */
public class math_23375_armCoordination {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(br.readLine());

        bw.write(String.format("%d %d\n%d %d\n%d %d\n%d %d", x - r, y + r, x + r, y + r, x + r, y - r, x - r, y - r));
        bw.flush();
        bw.close();
        br.close();
    }

}
