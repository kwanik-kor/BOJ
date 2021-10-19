package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16934
 * 2. 풀이
 *  - 본 문제는 주어진 닉네임에서 가장 짧은 접두사를 찾되, 중복되지 않게끔 처리해야 한다.
 *   > 단, 별칭이 절대 안겹치는 것은 아니기 때문에 접두사가 생성되는 시점에 카운트업을 해줘야 AC를 받을 수 있다.
 */
public class ds_trie_16934_gameNickname {

    static Trie trie = new Trie();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            String word = br.readLine();
            String byname = trie.insert(word);
            bw.write(byname);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Trie {
        TrieNode root = new TrieNode();

        String insert(String word) {
            StringBuilder sb = new StringBuilder();
            boolean flag = false;

            TrieNode thisNode = this.root;
            for(int i = 0, n = word.length(); i < n; i++) {
                if(!flag)
                    sb.append(word.charAt(i));

                if(thisNode.getChildNode().get(word.charAt(i)) == null) {
                    thisNode.getChildNode().put(word.charAt(i), new TrieNode());
                    thisNode.getChildNode().get(word.charAt(i)).setEnd(true);
                    flag = true;
                }

                thisNode = thisNode.getChildNode().get(word.charAt(i));
            }
            if(thisNode.end)
                thisNode.cnt = thisNode.cnt + 1;

            if(thisNode.cnt > 1)
                sb.append(thisNode.cnt);

            return sb.append("\n").toString();
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean end;
        int cnt = 0;

        Map<Character, TrieNode> getChildNode() {
            return this.childNode;
        }

        void setEnd(boolean end) {
            this.end = end;
        }
    }
}
