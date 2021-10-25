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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/3080
 * 2. 풀이
 *  1) 처음에 단순 Trie 구현과 함께 자식 노드의 개수만큼 팩토리얼을 취해서 답을 구했었다.
 *    하지만, 이는 Trie 자료구조의 고질적인 문제인 메모리 문제로 인해 통과할 수 없었다.
 *  2) 정렬
 *    문제에 힌트가 있었다. '사전순으로 정렬하면, 항상 상근이의 규칙을 지킬 수 있다'
 *    >> 주어진 문자열을 정렬할 경우, i 번째 단어는 i - 1번째 단어나 i + 1번째 단어와 Prefix가 가장 많이 겹치게 된다.
 *    >> 즉, 단어를 끝까지 저장하는 것이 아닌 중복되는 부분까지만 저장해서 Trie에 저장되는 문자열을 최소화 하는 것이 포인트였다.
 */
public class ds_trie_03080_beautifulName {

    static final long MOD = 1000000007L;

    static long[] factorial = new long[100];

    static void initFact() {
        factorial[1] = 1L;
        for(int i = 2, n = factorial.length; i < n; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        initFact();

        List<String> words = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            words.add(br.readLine());
        }
        Collections.sort(words);

        TrieNode trie = new TrieNode();
        int cur = 0, prev = 0;
        for(int i = 0; i < N; i++) {
            if(i == N - 1) {
                trie.insert(words.get(i), 0, prev + 1);
            } else {
                for(int j = 0, len = words.get(i).length(); j < len; j++) {
                    if(words.get(i).charAt(j) != words.get(i + 1).charAt(j))
                        break;
                    cur = j;
                }
                trie.insert(words.get(i), 0, Math.max(cur, prev) + 1);
                prev = cur;
            }
        }

        bw.write(solve(trie) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static long solve(TrieNode node) {
        int cnt = 0;
        long ret = 1L;
        for(Character key : node.getChildNode().keySet()) {
            ret *= solve(node.getChildNode().get(key));
            ret %= MOD;
            cnt++;
        }
        return ret * factorial[cnt + (node.isEnd? 1 : 0)] % MOD;
    }

    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean isEnd;

        void insert(String word, int idx, int length) {
            if(length == -1 || word.length() <= idx) {
                this.isEnd = true;
                return;
            }
            TrieNode child = this.getChildNode().computeIfAbsent(word.charAt(idx), c -> new TrieNode());
            child.insert(word, idx + 1, length - 1);
        }

        Map<Character, TrieNode> getChildNode() {
            return this.childNode;
        }

        void setEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }


    }
}
