package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/3135
 */
public class sml_03135_radio {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int ans = Math.abs(A - B);

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            ans = Math.min(ans, Math.abs(Integer.parseInt(br.readLine()) - B) + 1);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
