package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sml_25165_portal {

    static final String YES = "YES!";
    static final String NO = "NO...";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int ari = Integer.parseInt(st.nextToken());
        boolean isLeft = Integer.parseInt(st.nextToken()) == 0;

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        if (y == N) {
            bw.write((N % 2 == 0 && !isLeft) || (N % 2 == 1 && isLeft) ? YES : NO);
        } else {
            bw.write(NO);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
