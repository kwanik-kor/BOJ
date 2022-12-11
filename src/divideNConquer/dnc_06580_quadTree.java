package divideNConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6580
 */
public class dnc_06580_quadTree {

    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().split(" ")[2]);
        map = new boolean[N][N];

        callUnusableLine(br, 2);

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(",");
            for (int j = 0; j < N / 8; j++) {
                setUpMapByHexCode(input[j], i, j * 8);
            }
        }

        callUnusableLine(br, 1);

        bw.write(N + "\n");
        write(bw, 0, 0, N);

        bw.flush();
        bw.close();
        br.close();
    }

    static void write(BufferedWriter bw, int row, int col, int size) throws IOException {
        boolean flag = true;
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[row][col] != map[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            bw.write(map[row][col] ? "B" : "W");
        } else {
            bw.write("Q");
            size >>= 1;
            write(bw, row, col, size);
            write(bw, row, col + size, size);
            write(bw, row + size, col, size);
            write(bw, row + size, col + size, size);
        }
    }

    static void setUpMapByHexCode(String hexCode, int row, int col) {
        String hexBinaryString = Integer.toBinaryString(Integer.decode(hexCode));
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 8 - hexBinaryString.length()) {
            sb.append('0');
        }
        sb.append(hexBinaryString);

        char[] pixel = sb.reverse().toString().toCharArray();
        for (int i = 0; i < 8; i++) {
            map[row][col + i] = pixel[i] == '1';
        }
    }

    static void callUnusableLine(BufferedReader br, int cnt) throws IOException {
        while (cnt-- > 0) {
            br.readLine();
        }
    }
}
