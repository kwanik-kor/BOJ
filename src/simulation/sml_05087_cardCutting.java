package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5087
 */
public class sml_05087_cardCutting {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String line = br.readLine();
            if (line.equals("#")) break;

            int[] arr = Arrays.stream(line.split(" "))
                    .map(str -> {
                        if (str.equals("*"))
                            return "-1";
                        return str.equals("A") ? "1" : str;
                    })
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int odd = 0;
            int even = 0;
            for (int i = 0, n = arr.length; i < n; i++) {
                if (arr[i] == -1) {
                    break;
                }
                if (arr[i] % 2 == 0) even++;
                else odd++;
            }

            if (odd == even) {
                bw.write("Draw\n");
            } else if (odd > even) {
                bw.write("Cheryl\n");
            } else {
                bw.write("Tania\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
