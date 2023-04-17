package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1422
 */
public class greedy_01422_godOfNumber {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        bw.write(new greedy_01422_godOfNumber().solve());

        bw.close();
        br.close();
    }

    private String solve() throws Exception {
        List<String> list = initializeAndGetAppendedList();

        list.sort((a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);

        return sb.toString();
    }

    private List<String> initializeAndGetAppendedList() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<String> ret = new LinkedList<>();
        int max = 0;

        for (int i = 0; i < k; i++) {
            ret.add(br.readLine());
            max = Math.max(max, Integer.parseInt(ret.get(i)));
        }

        for (int i = 0, len = n - k; i < len; i++) {
            ret.add(String.valueOf(max));
        }

        return ret;
    }

}
