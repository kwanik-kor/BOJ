package simulation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/13458
 */
public class sml_13458_testSupervisor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" "))
                        .mapToLong(Long::parseLong)
                        .toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int main = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());

        long tot = 0L;
        for (int i = 0; i < N; i++) {
            tot++;

            if (arr[i] <= main) {
                continue;
            }

            arr[i] -= main;
            tot += arr[i] / sub + (arr[i] % sub != 0 ? 1L : 0);
        }

        bw.write(tot + "");
        bw.close();
        br.close();
    }

}
