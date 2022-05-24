package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/9950
 */
public class sml_09950_rectangles {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] arr = new int[3];
        while (true) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            }

            if (arr[0] == 0) {
                arr[0] = arr[2] / arr[1];
            } else if (arr[1] == 0) {
                arr[1] = arr[2] / arr[0];
            } else {
                arr[2] = arr[0] * arr[1];
            }
            bw.write(String.format("%d %d %d\n", arr[0], arr[1], arr[2]));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
