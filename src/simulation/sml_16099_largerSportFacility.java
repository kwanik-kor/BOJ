package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/16099
 */
public class sml_16099_largerSportFacility {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            List<BigInteger> arr = Arrays.stream(br.readLine().split(" "))
                    .map(BigInteger::new)
                    .collect(Collectors.toList());
            BigInteger a = arr.get(0).multiply(arr.get(1));
            BigInteger b = arr.get(2).multiply(arr.get(3));
            if (a.equals(b)) {
                bw.write("Tie\n");
            } else if (a.compareTo(b) < 0) {
                bw.write("Eurecom\n");
            } else {
                bw.write("TelecomParisTech\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
