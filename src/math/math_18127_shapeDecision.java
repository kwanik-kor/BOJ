package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 1. 문제링크: https://www.acmicpc.net/problem/18127
 */
public class math_18127_shapeDecision {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long interval = A - 2;
        long flag = 1L;
        long tot = 1L;
        for(int i = 0; i < B; i++) {
            flag += interval;
            tot += flag;
        }
        bw.write(tot + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
