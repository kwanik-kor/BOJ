package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/22155
 */
public class sml_22155_simpleProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.write(isSimple(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) ? "Yes\n" : "No\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isSimple(int a, int b) {
        return (a <= 1 && b <= 2) || (a <= 2 && b <= 1);
    }
}
