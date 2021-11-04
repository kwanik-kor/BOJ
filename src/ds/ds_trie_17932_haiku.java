package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/17932
 * 2. 풀이
 *  - Trie 구조로 음절들을 저장해두고, backtracking을 이용해 해당 라인이 하이쿠 조건에 부합하는지 확인한다.
 */
public class ds_trie_17932_haiku {

    static final int[] HAIKU = {4, 6, 4};

    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();
        while(N-- > 0) {
            trie.insert(br.readLine());
        }

        boolean flag = true;
        for(int i = 0; i < 3; i++) {
            String line = br.readLine();
            flag = trie.search(line, 0, HAIKU[i]);
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

        boolean search(String line, int start, int syllable) {
            if(syllable < 0)
                return false;

            TrieNode node = this.root;
            for(int i = start, n = line.length(); i < n; i++) {
                if(line.charAt(i) == ' ') {
                    if(!node.isEnd)
                        return false;
                    else
                        return search(line, i + 1, syllable - 1);
                } else {
                    if(node.isEnd && search(line, i, syllable - 1))
                        return true;
                }
                node = node.getChildNode().get(line.charAt(i));
                if(node == null)
                    return false;
            }

            return node != null && node.isEnd && syllable == 0;
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
