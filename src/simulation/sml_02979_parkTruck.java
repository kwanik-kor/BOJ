package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2979
 */
public class sml_02979_parkTruck {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] cost = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int[] parkingLot = new int[101];
        int[] A = stringToArray(br.readLine());
        int[] B = stringToArray(br.readLine());
        int[] C = stringToArray(br.readLine());
        for (int i = A[0]; i < A[1]; i++) {
            parkingLot[i]++;
        }
        for (int i = B[0]; i < B[1]; i++) {
            parkingLot[i]++;
        }
        for (int i = C[0]; i < C[1]; i++) {
            parkingLot[i]++;
        }


        int tot = 0;
        for (int i = 1; i <= 100; i++) {
            if (parkingLot[i] == 0) continue;
            tot += parkingLot[i] == 1 ? cost[0] : (parkingLot[i] == 2 ? cost[1] * 2 : cost[2] * 3);
        }

        bw.write(tot + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] stringToArray(String line) {
        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
