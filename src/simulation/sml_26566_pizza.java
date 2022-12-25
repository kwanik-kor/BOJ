package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26566
 */
public class sml_26566_pizza {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double p1 = Double.parseDouble(st.nextToken());

            st = new StringTokenizer(br.readLine());
            double r = Double.parseDouble(st.nextToken());
            double p2 = Double.parseDouble(st.nextToken());

            if ((a / p1) > (r * r * Math.PI) / p2) {
                bw.write("Slice of pizza\n");
            } else {
                bw.write("Whole pizza\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
