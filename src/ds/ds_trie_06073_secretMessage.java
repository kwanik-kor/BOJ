package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/6073
 * 2. 풀이
 *  - 문자열(비트) 를 미리 Trie 자료구조에 세팅해두는데, 이 때 종료 노드와 해당 노드를 포함하는 문자열의 개수를 함께 저장한다.
 *   - 갈취한 문자열을 root부터 순차적으로 탐색하며 해당 노드가 포함된 개수를 카운트한다.
 */
public class ds_trie_06073_secretMessage {

    static int M, N;
    static Trie trie = new Trie();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int[] bits = new int[len];
            for(int i = 0; i < len; i++) {
                bits[i] = Integer.parseInt(st.nextToken());
            }
            trie.insert(bits);
        }

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());

            int cnt = 0;
            TrieNode node = trie.root;
            for(int i = 0; i < len; i++) {
                int bit = Integer.parseInt(st.nextToken());
                if(node == null) continue;
                cnt += node.end;
                node = node.getChildNode()[bit];
            }
            if(node != null)
                cnt += node.cnt;

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(int[] arr) {
            TrieNode thisNode = this.root;
            for(int i = 0, n = arr.length; i < n; i++) {
                int bit = arr[i];
                if(thisNode.getChildNode()[bit] == null)
                    thisNode.getChildNode()[bit] = new TrieNode();
                thisNode = thisNode.getChildNode()[bit];
                thisNode.cnt = thisNode.cnt + 1;
            }
            thisNode.end = thisNode.end + 1;
        }
    }

    static class TrieNode {
        TrieNode[] childNode = new TrieNode[2];
        int cnt, end;

        TrieNode[] getChildNode() {
            return this.childNode;
        }
    }
}
