package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16906
 * 2. 풀이
 *  - 만들어진 단어가 다른 단어의 접두어가 되지 않게끔, 주어진 길이에 해당하는 단어를 만들어내야 한다.
 *   > Trie 자료구조를 통해, 이미 만들어진 단어의 마지막 글자(비트)에 isUsed를 true로 설정해주고
 *     재귀로 순환을 하면서 isUsed인 경우는 거르면 된다.
 */
public class ds_trie_16906_ukjaeWord {

    static int N;
    static Trie trie = new Trie();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Word[] words = new Word[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            words[i] = new Word(i, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(words, (a, b) -> a.length - b.length);
        boolean flag = true;
        for(Word word : words) {
            String ret = trie.insert(trie.root, 1, word.length, "");
            if(ret.equals("")) {
                flag = false;
                break;
            }
            word.word = ret;
        }

        if(!flag) {
            bw.write("-1");
        } else {
            Arrays.sort(words, (a, b) -> a.idx - b.idx);
            bw.write("1\n");
            for(Word word : words) {
                bw.write(word.word + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Trie {
        TrieNode root = new TrieNode();

        String insert(TrieNode node, int length, int size, String word) {
            if(length > size) {
                node.setUsed(true);
                return word;
            }
            String ret = "";

            for(int bit = 0; bit < 2; bit++) {
                if(!ret.equals("")) break;

                TrieNode next = node.getChildNode()[bit];
                if(next == null)
                    next = new TrieNode();

                if(!next.isUsed) {
                    node.getChildNode()[bit] = next;
                    ret = insert(node.getChildNode()[bit], length + 1, size, word + bit);
                }
            }

            return ret;
        }
    }

    static class TrieNode {
        TrieNode[] childNode = new TrieNode[2];
        boolean isUsed;

        TrieNode[] getChildNode() {
            return this.childNode;
        }

        void setUsed(boolean isUsed) {
            this.isUsed = isUsed;
        }
    }

    static class Word {
        int idx, length;
        String word;
        public Word(int idx, int length) {
            this.idx = idx;
            this.length = length;
        }
    }
}
