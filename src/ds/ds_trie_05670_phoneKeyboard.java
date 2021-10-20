package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5670
 * 2. 풀이
 *  - 주어진 단어목록의 자동완성 기능을 이용한 입력 횟수를 출력하는 문제.
 *   > Trie 구조에 먼저 입력받은 단어들을 모두 세팅한다.
 *   > 이후 자식노드 탐색을 시작하는데, 자식노드가 2개 이상이거나 현재 노드가 종료노드라면 입력횟수가 증가하게 된다.
 *    > ex) hello / hell 이 있다면 hell이 종료노드이기 떄문에 자동완성은 hell에서 마치게 됨
 *    > ex) hell / heaven 이 있다면 he 다음 l 과 a 로 나뉘기 때문에 자동완성은 he에서 마치게 됨
 */
public class ds_trie_05670_phoneKeyboard {

    static double tot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = "";
        while((line = br.readLine()) != null && !line.equals("")) {
            int N = Integer.parseInt(line);
            Trie trie = new Trie();
            for(int i = 0; i < N; i++) {
                trie.insert(br.readLine());
            }

            tot = 0d;
            for(TrieNode root : trie.root.getChildNode().values()) {
                trie.dfs(root, 1);
            }

            bw.write(String.format("%.2f\n", tot / N));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode thisNode = this.root;
            for(int i = 0, n = word.length(); i < n; i++) {
                thisNode = thisNode.childNode.computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            thisNode.setEnd(true);
        }

        void dfs(TrieNode node, int cnt) {
            if(node.isEnd) {
                tot += cnt;
            }

            int childCnt = node.getChildNode().size();
            for(TrieNode child : node.getChildNode().values()) {
                dfs(child, (childCnt == 1 && !node.isEnd)? cnt : cnt + 1);
            }
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
