package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ds_trie_16906_ukjaeWord {

    static int N;
    static StringBuilder ans = new StringBuilder();

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
        for(Word word : words) {

        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Trie {
        TrieNode root = new TrieNode();

        String insert(int length) {
            StringBuilder word = new StringBuilder();
            TrieNode thisNode = this.root;

            for(int i = 0; i < length; i++) {

            }

            return word.toString();
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
