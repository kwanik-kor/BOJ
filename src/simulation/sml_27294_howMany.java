package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. https://www.acmicpc.net/problem/27294
 */
public class sml_27294_howMany {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        if (12 <= arr[0] && arr[0] <= 16 && arr[1] == 0) {
            bw.write("320");
        } else {
            bw.write("280");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
