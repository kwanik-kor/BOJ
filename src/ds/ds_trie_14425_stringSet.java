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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/14425
 * 2. 풀이
 *  - 트라이 라는 자료구조에 대한 이해를 위해 처음으로 풀어본 문제.
 *  - 사실 트라이에 대해서는 아직 긴가민가쓰..
 *
 * 3. 자료구조 트라이(TRIE)
 *  - 문자열 특화 자료구조로, 문자열의 집합을 표현하는 트리 자료 구조
 *  - 집합 내에서 원하는 원소를 찾는 작업을 O(M)에 할 수 있음
 *  - 트라이의 노드를 표현하는 객체의 구성
 *    > 자손 노드들을 가리키는 포인터 목록
 *    > 종료노드인지를 나타내는 Boolean 값 변수
 *
 *  - 단, 문자열 길이에 따라 메모리 사용량이 많아지는 것이 단점임
 */
public class ds_trie_14425_stringSet {

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

    // class model 설계 참고 : https://the-dev.tistory.com/3
    static class Trie {
        // Root Node
        private TrieNode rootNode;

        Trie() {
            rootNode = new TrieNode();
        }

        void insert(String word) {
            TrieNode thisNode = this.rootNode;

            for(int i = 0, n = word.length(); i < n; i++) {
                thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            thisNode.setIsLastChar(true);
        }

        // 특정 단어가 들어있는지 확인
        boolean contains(String word) {
            TrieNode thisNode = this.rootNode;

            for(int i = 0, n = word.length(); i < n; i++) {
                char c = word.charAt(i);
                TrieNode node = thisNode.getChildNodes().get(c);
                if(node == null)
                    return false;
                thisNode = node;
            }

            return thisNode.isLastChar();
        }

        // 트라이에 넣었던 단어 삭제
        void delete(String word) {
            delete(this.rootNode, word, 0);
        }

        private void delete(TrieNode thisNode, String word, int index) {
            char c = word.charAt(index);

            if(!thisNode.getChildNodes().containsKey(c)) {
                System.out.println("No Character in the trie");
                return;
            }

            TrieNode childNode = thisNode.getChildNodes().get(c);
            index++;

            if(index == word.length()) {
                if(childNode.isLastChar()) {
                    childNode.setIsLastChar(false);
                    if(childNode.getChildNodes().isEmpty())
                        thisNode.getChildNodes().remove(c);
                }
            } else {
                delete(childNode, word, index);
                if(!childNode.isLastChar() && childNode.getChildNodes().isEmpty())
                    thisNode.getChildNodes().remove(c);
            }

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
