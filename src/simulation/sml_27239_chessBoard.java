package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/27239
 */
public class sml_27239_chessBoard {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int row = N / 8 + (N % 8 == 0 ? 0 : 1);
        int col = N % 8 == 0 ? 8 : N % 8;

        bw.write(((char) (col + 'a' - 1)) + "" + row);
        bw.flush();
        bw.close();
        br.close();
    }
}
