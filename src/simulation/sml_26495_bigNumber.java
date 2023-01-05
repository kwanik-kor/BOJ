package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26495
 */
public class sml_26495_bigNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Number num = new Number();
        char[] arr = br.readLine().toCharArray();

        for (int i = 0, n = arr.length; i < n; i++) {
            bw.write(num.getNumberString(arr[i] - '0'));
            if (i != n - 1) {
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Number {
        final String[] numbers;

        public Number() {
            this.numbers = new String[10];
            numbers[0] = "0000\n0  0\n0  0\n0  0\n0000\n";
            numbers[1] = "   1\n   1\n   1\n   1\n   1\n";
            numbers[2] = "2222\n   2\n2222\n2\n2222\n";
            numbers[3] = "3333\n   3\n3333\n   3\n3333\n";
            numbers[4] = "4  4\n4  4\n4444\n   4\n   4\n";
            numbers[5] = "5555\n5\n5555\n   5\n5555\n";
            numbers[6] = "6666\n6\n6666\n6  6\n6666\n";
            numbers[7] = "7777\n   7\n   7\n   7\n   7\n";
            numbers[8] = "8888\n8  8\n8888\n8  8\n8888\n";
            numbers[9] = "9999\n9  9\n9999\n   9\n   9\n";
        }

        public String getNumberString(int n) {
            return this.numbers[n];
        }
    }
}
