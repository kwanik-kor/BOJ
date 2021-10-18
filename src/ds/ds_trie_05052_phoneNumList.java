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

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5052
 * 2. 풀이
 *  - Trie 자료구조를 통해 접두사가 포함된 전화번호가 나타난다면 False로 처리한다.
 *   > 이를 위한 조건은 입력받은 번호 목록을 자리수를 기준으로 정렬이 선행되어야 한다.
 *     >> 이를 간과해서 한 번 틀림
 */
public class ds_trie_05052_phoneNumList {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            Trie trie = new Trie();

            List<String> words = new ArrayList<>();
            for(int n = 0; n < N; n++) {
                words.add(br.readLine());
            }
            words.sort((a, b) -> a.length() - b.length());

            boolean flag = true;
            for(String number : words) {
                if(!flag) continue;
                flag = trie.insert(number);
            }
            bw.write(flag? "YES\n" : "NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Trie {
        TrieNode rootNode = new TrieNode();

        boolean insert(String word) {
            TrieNode thisNode = this.rootNode;
            for(int i = 0, n = word.length(); i < n; i++) {
                // make a flag on here
                if(thisNode.getChildNodes().containsKey(word.charAt(i)) && thisNode.getChildNodes().get(word.charAt(i)).isLastChar()) {
                    return false;
                }
                thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            thisNode.setIsLastChar(true);
            return true;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> childNodes = new HashMap<>();
        boolean isLastChar;

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
