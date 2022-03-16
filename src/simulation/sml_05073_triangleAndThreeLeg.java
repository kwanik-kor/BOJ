package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5073
 */
public class sml_05073_triangleAndThreeLeg {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0 && c == 0)
                break;

            int max = Math.max(a, Math.max(b, c));
            if(a + b + c - max <= max) {
                bw.write("Invalid\n");
            } else {
                if(a == b && b == c) bw.write("Equilateral\n");
                else if(a == b || b == c || c == a) bw.write("Isosceles\n");
                else bw.write("Scalene\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
