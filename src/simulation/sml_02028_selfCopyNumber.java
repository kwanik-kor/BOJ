package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2028
 */
public class sml_02028_selfCopyNumber {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String word = br.readLine();
            char[] squared = String.valueOf(Integer.parseInt(word) * Integer.parseInt(word)).toCharArray();

            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (squared[squared.length - i - 1] != word.charAt(word.length() - i - 1)) {
                    flag = false;
                    break;
                }
            }

            bw.write(flag ? "YES\n" : "NO\n");
        }

        bw.close();
        br.close();
    }

}
