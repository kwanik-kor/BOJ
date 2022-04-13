package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5635
 */
public class sml_05635_birth {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] names = new String[N];

        int minIdx = -1, maxIdx = -1;
        Date now = new Date();
        Date min = null;
        Date max = null;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            String dateStr = st.nextToken() + " " + st.nextToken() + " " + st.nextToken();
            Date date = new SimpleDateFormat("dd MM yyyy").parse(dateStr);
            if (min == null) {
                min = date;
            } else if (min.compareTo(date) < 0) {
                min = date;
                minIdx = i;
            }
            if (max == null) {
                max = date;
            } else if (max.compareTo(date) > 0) {
                max = date;
                maxIdx = i;
            }
        }
        bw.write(names[minIdx] + "\n" + names[maxIdx]);
        bw.flush();
        bw.close();
        br.close();
    }
}
