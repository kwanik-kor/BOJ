package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1251
 */
public class bf_01251_separateWord {

    static HashSet<String> words = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        separateWord(br.readLine());
        List<String> word = new ArrayList<>(words);
        Collections.sort(word);
        bw.write(word.get(0));
        bw.flush();
        bw.close();
        br.close();
    }

    static void separateWord(String word) {
        int n = word.length();
        for(int j = 1; j < n - 1; j++) {
            for(int k = j + 1; k < n; k++) {
                String newWord = convertWord(word.substring(0, j)) + convertWord(word.substring(j, k)) + convertWord(word.substring(k));
                words.add(newWord);
            }
        }
    }

    static String convertWord(String word) {
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }
}
