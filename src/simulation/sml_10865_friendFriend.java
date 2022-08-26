package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/10865
 */
public class sml_10865_friendFriend {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] condition = convertLineToIntArr(br.readLine());

        int[] friends = new int[condition[0] + 1];
        for (int i = 0; i < condition[1]; i++) {
            int[] line = convertLineToIntArr(br.readLine());
            for (int j = 0, n = line.length; j < n; j++) {
                friends[line[j]]++;
            }
        }

        for (int i = 1; i <= condition[0]; i++) {
            bw.write(friends[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] convertLineToIntArr(String line) {
        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
