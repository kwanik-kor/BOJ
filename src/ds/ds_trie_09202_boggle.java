package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/9202
 * 2. 풀이
 *  1) 단어 사전의 단어들을 Trie 에 모두 insert 해둔다.
 *  2) Query 별로 주어진 Map을 DFS를 이용해 탐색하면서 Trie에서 찾을 수 있는 모든 단어를 Set에 저장한다.
 *    - 같은 단어를 여러 번 찾을 경우 한 번만 찾은 것으로 하기 때문
 *  3) 최종적으로, 출력 조건에 맞춰서 출력한다.
 */
public class ds_trie_09202_boggle {

    static final int[] SCORE = {0, 0, 0, 1, 1, 2, 3, 5, 11};

    static int maxCnt = 0;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    static Trie dict = new Trie();
    static Set<String> set = new HashSet<>();

    static char[][] map;
    static boolean[][] visit;

    static void dfs(int y, int x, TrieNode node, int length, String word) {
        if(length > maxCnt) return;

        visit[y][x] = true;
        word += map[y][x];
        node = node.getChildNode().get(map[y][x]);
        if(node == null) {
            visit[y][x] = false;
            return;
        }

        if(node.end)
            set.add(word);

        for(int dir = 0; dir < 8; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(ny < 0 || nx < 0 || 4 <= ny || 4 <= nx || visit[ny][nx]) continue;
            dfs(ny, nx, node, length + 1, word);
        }

        visit[y][x] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int W = Integer.parseInt(br.readLine());
        while(W-- > 0) {
            String word = br.readLine();
            maxCnt = Math.max(maxCnt, word.length());
            dict.insert(word);
        }

        br.readLine();

        int Q = Integer.parseInt(br.readLine());
        while(Q-- > 0) {
            // init
            map = new char[4][4];
            visit = new boolean[4][4];
            set = new HashSet<>();
            for(int i = 0; i < 4; i++) {
                map[i] = br.readLine().toCharArray();
            }
            if(Q != 0) br.readLine();

            // solve
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    dfs(i, j, dict.root, 0, "");
                }
            }

            int tot = 0;
            String longestWord = "";
            for(String word : set) {
                tot += SCORE[word.length()];
                if(longestWord.length() < word.length()) {
                    longestWord = word;
                } else if(longestWord.length() == word.length() && longestWord.compareTo(word) > 0) {
                    longestWord = word;
                }
            }

            bw.write(String.format("%d %s %d\n", tot, longestWord, set.size()));
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
                thisNode = thisNode.getChildNode().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            thisNode.setEnd(true);
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean end;

        Map<Character, TrieNode> getChildNode() {
            return this.childNode;
        }

        void setEnd(boolean end) {
            this.end = end;
        }
    }
}
