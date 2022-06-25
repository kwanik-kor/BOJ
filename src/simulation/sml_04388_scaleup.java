package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4388
 */
public class sml_04388_scaleup {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if (a.equals("0") && b.equals("0")) break;

            int max = Math.max(a.length(), b.length());
            int dif = Math.abs(a.length() - b.length());
            if (a.length() > b.length()) {
                b = getAppendedString(b, dif);
            } else {
                a = getAppendedString(a, dif);
            }

            int cnt = 0;
            int carry = 0;
            for (int i = max - 1; i >= 0; i--) {
                if ((a.charAt(i) - '0') + (b.charAt(i) - '0') + carry >= 10) {
                    cnt++;
                    carry = 1;
                } else {
                    carry = 0;
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static String getAppendedString(String str, int len) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < len; i++) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}
