package dfs;

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
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/14725
 * 2. 풀이
 *  - Trie 자료구조를 이용해, 문자열의 트리구조를 생성한다.
 *   > 추후 DFS 탐색을 통해 노드의 상하 관계를 출력한다.
 */
public class dfs_14725_antCave {

    static int N;
    static TrieNode trie = new TrieNode();
    static StringBuilder sb = new StringBuilder();

    static void dfs(TrieNode trie, int idx) {
        StringBuilder dash = new StringBuilder();
        for(int i = 0; i < idx; i++) {
            dash.append("--");
        }

        List<String> nodes = new ArrayList<>(trie.getChildNodes().keySet());
        if(!nodes.isEmpty())
            Collections.sort(nodes);

        for(String node : nodes) {
            sb.append(dash.toString() + node + "\n");
            dfs(trie.getChildNodes().get(node), idx + 1);
        }
    }

    static void insert(String[] arr, TrieNode trieNode, int idx) {
        if(idx == arr.length)
            return;
        if(!trieNode.getChildNodes().containsKey(arr[idx])) {
            trieNode.getChildNodes().put(arr[idx], new TrieNode());
        }
        insert(arr, trieNode.getChildNodes().get(arr[idx]), idx + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
             st = new StringTokenizer(br.readLine());
             int K = Integer.parseInt(st.nextToken());
             String[] words = new String[K];
             for(int k = 0; k < K; k++) {
                 words[k] = st.nextToken();
             }
             insert(words, trie, 0);
        }
        dfs(trie, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class TrieNode {
        Map<String, TrieNode> childNodes = new HashMap<>();
        Map<String, TrieNode> getChildNodes() { return this.childNodes; }
    }

}
