package algospot.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Wildcard {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] memo = new int[101][101];
    private static char[] pattern, word;
    private static int patternLength, wordLength;

    public static void main(String[] args) throws Exception {
        Wildcard wildcard = new Wildcard();
        int c = Integer.parseInt(br.readLine());
        while (c-- > 0) {
            wildcard.solve();
        }
    }

    void solve() throws Exception {
        pattern = br.readLine().toCharArray();
        patternLength = pattern.length;

        int N = Integer.parseInt(br.readLine());
        List<String> answers = new ArrayList<>();

        while (N-- > 0) {
            initialize();

            if (isPatternMatched(0, 0)) {
                answers.add(new String(word));
            }
        }

        Collections.sort(answers);
        for (String answer : answers) {
            System.out.println(answer);
        }
    }

    private boolean isPatternMatched(int patternIdx, int wordIdx) {
        if (memo[patternIdx][wordIdx] != -1) {
            return memo[patternIdx][wordIdx] == 1;
        }

        while (patternIdx < patternLength
                && wordIdx < wordLength
                && (pattern[patternIdx] == '?' || pattern[patternIdx] == word[wordIdx])) {
            patternIdx++;
            wordIdx++;
        }

        memo[patternIdx][wordIdx] = 0;
        if (patternIdx == patternLength) {
            memo[patternIdx][wordIdx] = wordIdx == wordLength ? 1 : 0;
            return memo[patternIdx][wordIdx] == 1;
        }

        if (pattern[patternIdx] == '*') {
            for (int nextWordIdx = wordIdx; nextWordIdx <= wordLength; nextWordIdx++) {
                if (isPatternMatched(patternIdx + 1, nextWordIdx)) {
                    memo[patternIdx][wordIdx] = 1;
                    return true;
                }
            }
        }

        return false;
    }

    private void initialize() throws Exception {
        word = br.readLine().toCharArray();
        wordLength = word.length;
        Arrays.stream(memo).forEach(row -> Arrays.fill(row, -1));
    }

}
