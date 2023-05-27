package APC.n_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt++;
            if (String.valueOf(i).indexOf("50") != -1 && i != N) {
                cnt++;
            }
        }
        bw.write(cnt + "");
        bw.close();
        br.close();
    }
}
