package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5446
 * 2. 풀이
 *  - 지울 파일 명과 지워서는 안되는 파일 명을 모두 Trie 구조에 저장해둔다.
 *   > 글자별로 순회를 하되 해당 글자가 지워도 되는 경우 ans를 증가시키고 순회를 중단한다.
 *   > 단, 지워야하는 파일 명이 지우면 안되는 파일 명의 접두사인 경우 ans를 따로 하나 증가시켜준다.
 *     ex) clean / cleanup
 *  - 정답은 맞게 나오는데 계속 틀려서 확인해보니 아래의 이유때문이다.
 *   > 지우면 안되는 파일이 없는 경우에는 '*' 와일드카드 한 번으로 rm 할 수 있다..........
 */
public class ds_trie_05446_lackOfMemory {

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            Trie trie = new Trie();
            ans = 0;

            int eraseCnt = Integer.parseInt(br.readLine());
            for(int i = 0; i < eraseCnt; i++) {
                trie.insert(br.readLine(), 0);
            }

            int liveCnt = Integer.parseInt(br.readLine());
            for(int i = 0; i < liveCnt; i++) {
                trie.insert(br.readLine(), 1);
            }

            if(liveCnt != 0) {
                for(TrieNode child : trie.root.getChildNode().values()) {
                    trie.search(child);
                }
            }

            bw.write((liveCnt == 0? 1 : ans) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word, int idx) {
            TrieNode thisNode = this.root;
            for(int i = 0, n = word.length(); i < n; i++) {
                thisNode = thisNode.childNode.computeIfAbsent(word.charAt(i), c -> new TrieNode());
                thisNode.check[idx] = 1;
            }
            thisNode.end[idx] = 1;
        }

        void search(TrieNode node) {
            if(node.check[1] == 0) {
                ans++;
                return;
            }

            if(node.end[0] == 1)
                ans++;

            for(TrieNode child : node.getChildNode().values())
                search(child);
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
        int[] check = new int[2];
        int[] end = new int[2];

        Map<Character, TrieNode> getChildNode() {
            return this.childNode;
        }
    }
}
