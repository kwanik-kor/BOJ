package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class ds_trie_17932_haiku {

    static final int[] HAIKU = {5, 7, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();
        while(N-- > 0) {
            trie.insert(br.readLine());
        }

        boolean flag = true;
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            flag = trie.search(line, HAIKU[i]);
            if(!flag) break;
        }

        bw.write(flag? "haiku" : "come back next year");
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
            }
            thisNode.setEnd(true);
        }

        boolean search(String line, int syllable) {
            boolean ret = true;
            String[] words = line.split(" ");

            return ret;
        }
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
