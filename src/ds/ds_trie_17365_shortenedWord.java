package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/17365
 * 2. 풀이
 *  - 먼저 주어진 단어를 Trie 자료구조에 밀어 넣으면서, 각 글자(접두사)의 노출 빈도를 설정한다.
 *  - 이후 해석하려는 단어를 글자별로 순회하면서 전체 경우의 수를 카운트 한다.
 */
public class ds_trie_17365_shortenedWord {

    static final int MOD = 1000000007;

    static int N;
    static long[] dp;
    static Trie trie = new Trie();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            trie.insert(br.readLine());
        }

        String word = br.readLine();
        dp = new long[word.length() + 1];
        dp[0] = 1L;
        for(int i = 0, n = word.length(); i < n; i++) {
            TrieNode node = trie.root;
            for(int j = i; j < n; j++) {
                if(!node.getChildNode().containsKey(word.charAt(j))) break;
                node = node.getChildNode().get(word.charAt(j));
                dp[j + 1] = (dp[j + 1] + dp[i] * node.cnt) % MOD;
            }
        }

        bw.write(dp[word.length()] + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode thisNode = this.root;
            for(int i = 0, n = word.length(); i < n; i++) {
                thisNode = thisNode.getChildNode().computeIfAbsent(word.charAt(i), c -> new TrieNode());
                thisNode.countUp();
            }
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
        int cnt = 0;

        Map<Character, TrieNode> getChildNode() {
            return this.childNode;
        }

        void countUp() {
            this.cnt = this.cnt + 1;
        }
    }
}
