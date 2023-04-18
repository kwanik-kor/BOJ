package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/13448
 */
public class greedy_13448_SwCompetencyTest {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, T;


    public static void main(String[] args) throws Exception {
        new greedy_13448_SwCompetencyTest().solve();

        bw.close();
        br.close();
    }

    private void solve() throws Exception {

    }

    private void initialize() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());


    }

}
