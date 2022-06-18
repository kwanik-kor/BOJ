package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/12756
 */
public class sml_12756_cardGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aA = Integer.parseInt(st.nextToken());
        int aD = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int bA = Integer.parseInt(st.nextToken());
        int bD = Integer.parseInt(st.nextToken());
        int flagA = aD / bA + (aD % bA == 0? 0 : 1);
        int flagB = bD / aA + (bD % aA == 0? 0 : 1);
        if (flagA == flagB)
            bw.write("DRAW");
        else if (flagA < flagB)
            bw.write("PLAYER B");
        else
            bw.write("PLAYER A");
        bw.flush();
        bw.close();
        br.close();
    }
}
