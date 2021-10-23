package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ds_trie_03080_beautifulName {

    static final long MOD = 1000000007L;

    static long[] factorial = new long[27];
    static long ans = 1L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        initFact();

        TrieNode root = new TrieNode();
        List<String> words = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            words.add(br.readLine());
        }
        Collections.sort(words);

        search(root);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void initFact() {
        factorial[1] = 1L;
        for(int i = 2, n = factorial.length; i < n; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }
    }

    static void insert(TrieNode root, String word) {
        TrieNode thisNode = root;
        for(int i = 0, n = word.length(); i < n; i++) {
            thisNode = thisNode.getChildNode().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.setEnd(true);
    }

    static void search(TrieNode node) {
        for(TrieNode child : node.getChildNode().values())
            search(child);
        ans = ans * factorial[Math.max(node.getChildNode().size(), 1)] % MOD;
    }

    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean isEnd = false;

        Map<Character, TrieNode> getChildNode() {
            return this.childNode;
        }

        void setEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }
    }
}
