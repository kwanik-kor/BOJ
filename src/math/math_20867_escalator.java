package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/20867
 */
public class math_20867_escalator {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double M = Double.parseDouble(st.nextToken());
        double S = Double.parseDouble(st.nextToken());
        double G = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double L = Double.parseDouble(st.nextToken());
        double R = Double.parseDouble(st.nextToken());

        double lw = L / A;
        double rw = R / B;
        double ls = M / (M % G == 0? G : G + 1);
        double rs = M / (M % S == 0? S : S + 1);

        if(ls + lw < rs + rw) bw.write("friskus");
        else bw.write("latmask");

        bw.flush();
        bw.close();
        br.close();
    }
}
