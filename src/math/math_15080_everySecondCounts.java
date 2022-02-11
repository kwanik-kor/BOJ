package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15080
 */
public class math_15080_everySecondCounts {

    static int[] seconds = {3600, 60, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> hms_1 = getTimeStringToIntList(br.readLine());
        List<Integer> hms_2 = getTimeStringToIntList(br.readLine());

        int time1 = getTotalSeconds(hms_1);
        int time2 = getTotalSeconds(hms_2);

        int ans = time2 - time1 + (time2 < time1 ? 24 * seconds[0] : 0);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static List<Integer> getTimeStringToIntList(String line) {
        return Arrays.stream(line.split(":"))
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
    }

    static int getTotalSeconds(List<Integer> time) {
        return IntStream.range(0, time.size())
                .map(idx -> time.get(idx) * seconds[idx])
                .sum();
    }
}
