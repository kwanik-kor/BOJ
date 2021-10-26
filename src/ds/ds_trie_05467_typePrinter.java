package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5467
 */
public class ds_trie_05467_typePrinter {

    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        // input & init
        List<String> words = new ArrayList<>();
        for(int i = 0; i < N; i++)
            words.add(br.readLine());



        // bye..

        bw.flush();
        bw.close();
        br.close();
    }

    static void appendDash(int cnt) {
        for(int i = 0; i < cnt; i++)
            ans.append("-\n");
    }

    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean isEnd;

        Map<Character, TrieNode> getChildNode() {
            return this.childNode;
        }

        void setEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }
    }
}
