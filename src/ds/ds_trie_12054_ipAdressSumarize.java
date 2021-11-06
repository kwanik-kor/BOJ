package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ds_trie_12054_ipAdressSumarize {

    static List<String> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            Trie trie = new Trie();
            String[] address = new String[n];
            ans = new ArrayList<>();

            StringBuilder subnet;
            for(int i = 0; i < n; i++) {
                String[] ip = br.readLine().split("[./]");
                int len = Integer.parseInt(ip[4]);
                subnet = new StringBuilder();

                for(int j = 0; j < 4; j++) {
                    ip[j] = String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(ip[j]))));
                    int idx = 0;
                    while(len > 0 && idx < 8) {
                        subnet.append(ip[j].charAt(idx));
                        len--;
                        idx++;
                    }
                }

                trie.insert(subnet.toString());
            }

            trie.normalization(trie.root, "");

            Collections.sort(ans);

            bw.write(String.format("Case #%d:\n", t));
            for(String ip : ans)
                bw.write(ip);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String subnet) {
            TrieNode thisNode = this.root;
            for(int i = 0, n = subnet.length(); i < n; i++) {
                int bit = subnet.charAt(i) - '0';
                if(thisNode.getChildNodes()[bit] == null) {
                    thisNode.setChildNode(bit);
                }
                thisNode = thisNode.getChildNodes()[bit];
            }
            thisNode.setEnd(true);
        }

        void normalization(TrieNode node, String address) {
            if(node.isEnd) {
                subnetToIp(address);
                return;
            }

            for(int i = 0; i < 2; i++) {
                TrieNode child = node.getChildNodes()[i];
                if(child != null) {
                    normalization(child, address + i);
                }
            }
        }
    }

    static void subnetToIp(String address) {
        StringBuilder sb = new StringBuilder();

        int len = address.length();
        StringBuilder addressBuilder = new StringBuilder(address);
        for(int i = len; i < 32; i++)
            addressBuilder.append('0');
        address = addressBuilder.toString();

        for(int i = 0; i < 32; i += 8) {
            sb.append(Integer.parseInt(address.substring(i, i + 8), 2));
            if(i != 24)
                sb.append('.');
        }
        sb.append("/" + len + "\n");
        ans.add(sb.toString());
    }

    static class TrieNode {
        TrieNode[] childNode = new TrieNode[2];
        boolean isEnd;

        TrieNode[] getChildNodes() {
            return this.childNode;
        }

        void setChildNode(int idx) {
            this.childNode[idx] = new TrieNode();
        }

        void setEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }

        int getChildCnt() {
            return childNode[0] == null && childNode[1] == null? 0 : (childNode[0] != null && childNode[1] != null? 2 : 1);
        }
    }
}
