package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sml_08721_sequence {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        int n = 1;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == n) {
                n++;
            } else {
                cnt++;
            }
        }

        bw.write(cnt + "");
        bw.close();
        br.close();
    }

}
