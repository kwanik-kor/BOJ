package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/21665
 */
public class sml_21665_Мишаинегатив {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] map = new char[row][col];

        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }

        br.readLine();
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                if (map[i][j] == arr[j]) cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
