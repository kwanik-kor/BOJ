package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1681
 */
public class bf_01681_lineUp {

    static char L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        L = st.nextToken().charAt(0);

        int num = 0;
        while (N-- > 0) {
            num = makePossibleNumber(++num);
        }

        bw.write(num + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int makePossibleNumber(int n) {
        return String.valueOf(n).indexOf(L) != -1
                ? makePossibleNumber(n + 1)
                : n;
    }
}
