package simulation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sml_25305_cutline {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = lineToReverseSortedArray(br.readLine());
        bw.write(-arr[k - 1] + "");
        bw.close();
        br.close();
    }

    private static int[] lineToReverseSortedArray(String readLine) {
        return Arrays.stream(readLine.split(" "))
                .mapToInt((str) -> -Integer.parseInt(str))
                .sorted()
                .toArray();
    }
}
