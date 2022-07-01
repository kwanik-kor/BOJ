package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4589
 */
public class sml_04589_gnomeSequencing {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        bw.write("Gnomes:\n");

        while (T-- > 0) {
            Integer[] arr = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            if ((arr[0] < arr[1] && arr[1] < arr[2])
                || (arr[0] > arr[1] && arr[1] > arr[2])) {
                bw.write("Ordered\n");
            } else {
                bw.write("Unordered\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
