package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/14426
 * 2. 풀이
 *  - Trie 자료구조를 이용해, 제시된 접두사(Prefix)가 자료구조의 Root 부터 따라갈 수 있는지 탐색한다.
 */
public class ds_trie_14426_findPrefix {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        for(int i = 0; i < N; i++) {
            trie.insert(br.readLine());
        }

        int ans = 0;
        for(int i = 0; i < M; i++) {
            if(trie.contains(br.readLine()))
                ans++;
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Trie {
        TrieNode rootNode = new TrieNode();

        void insert(String word) {
            TrieNode thisNode = this.rootNode;
            for(int i = 0, n = word.length(); i < n; i++) {
                thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            thisNode.setIsLastChar(true);
        }

        boolean contains(String word) {
            TrieNode thisNode = this.rootNode;

            for(int i = 0, n = word.length(); i < n; i++) {
                char c = word.charAt(i);
                TrieNode node = thisNode.getChildNodes().get(c);
                if(node == null)
                    return false;
                thisNode = node;
            }

            return true;
        }
    }

    static class TrieNode {
        private Map<Character, TrieNode> childNodes = new HashMap<>();
        private boolean isLastChar;

        Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }

        boolean isLastChar() {
            return this.isLastChar;
        }

        void setIsLastChar(boolean isLastChar) {
            this.isLastChar = isLastChar;
        }
    }
}
