package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/status?user_id=rhksdlr134&problem_id=13073&from_mine=1
 */
public class sml_13073_sums {
    static int[] sum = new int[10001];
    static int[] odd = new int[10001];
    static int[] even = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        init();
        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine());
            bw.write(String.format("%d %d %d\n", sum[N], odd[N], even[N]));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void init() {
        int oddF = -1, evenF = 0;
        for (int i = 1; i <= 10000; i++) {
            sum[i] += sum[i - 1] + i;
            oddF += 2;
            evenF += 2;
            odd[i] += odd[i - 1] + oddF;
            even[i] += even[i - 1] + evenF;
        }
    }
}
