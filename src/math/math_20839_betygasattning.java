package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/20839
 */
public class math_20839_betygasattning {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        double C = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double AA = Double.parseDouble(st.nextToken());
        double BB = Double.parseDouble(st.nextToken());
        double CC = Double.parseDouble(st.nextToken());

        if(AA >= A && BB >= B && CC >= C)
            bw.write("A");
        else if(AA >= A / 2d && BB >= B && CC >= C)
            bw.write("B");
        else if(BB >= B && CC >= C)
            bw.write("C");
        else if(BB >= B / 2d && CC >= C)
            bw.write("D");
        else
            bw.write("E");

        bw.flush();
        bw.close();
        br.close();
    }

}
