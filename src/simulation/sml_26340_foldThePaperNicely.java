package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26340
 */
public class sml_26340_foldThePaperNicely {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[3];
            bw.write("Data set: ");

            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                bw.write(arr[i] + "");
                if (i != 2) {
                    bw.write(" ");
                } else {
                    bw.write("\n");
                }
            }

            int min = Math.min(arr[0], arr[1]);
            int max = Math.max(arr[0], arr[1]);
            while (arr[2]-- > 0) {
                int half = max / 2;
                max = Math.max(half, min);
                min = Math.min(half, min);
            }

            bw.write(max + " " + min + "\n");

            if (N != 0) {
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
