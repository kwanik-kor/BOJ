package dfs;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Base64;
import java.util.StringTokenizer;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class dfs_13502_wordPuzzle2_ByLink {

    static final int SIZE = 5;
    static final String DOWNLOAD_LINK = "https://d2gd6pc034wcta.cloudfront.net/data/1165.zip";

    static int ans = 0;
    static boolean flag = false;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    static Trie trie = new Trie();
    static String[] words;
    static char[][] puzzle = new char[SIZE][SIZE];
    static boolean[][] visit = new boolean[SIZE][SIZE];

    static void solve() {
        if(words == null)
            return;

        for(String word : words) {
            flag = false;
            for(int i = 0; i < SIZE; i++) {
                for(int j = 0; j < SIZE; j++) {
                    if(trie.root.children[puzzle[i][j] - 'A'] != null && word.charAt(0) == puzzle[i][j]) {
                        visit[i][j] = true;
                        dfs(i, j, 1, trie.root.children[puzzle[i][j] - 'A'], word);
                        visit[i][j] = false;
                    }
                    if(flag) break;
                }
                if(flag) break;
            }
        }
    }

    static void dfs(int y, int x, int depth, TrieNode current, String word) {
        if(flag) return;
        if(depth == word.length()) {
            ans++;
            flag = true;
            return;
        }

        for(int dir = 0; dir < 8; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(ny < 0 || nx < 0 || SIZE <= ny || SIZE <= nx || visit[ny][nx]) continue;
            if(current.children[puzzle[ny][nx] - 'A'] != null && word.charAt(depth) == puzzle[ny][nx]) {
                visit[ny][nx] = true;
                dfs(ny, nx, depth + 1, current.children[puzzle[ny][nx] - 'A'], word);
                visit[ny][nx] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException, DataFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < SIZE; j++) {
                puzzle[i][j] = st.nextToken().charAt(0);
            }
        }

        getWordsAndSetTrie();
//        solve();

//        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void getWordsAndSetTrie() throws IOException, DataFormatException {
        URL url = new URL(DOWNLOAD_LINK);
        StringBuilder sb = new StringBuilder();

        InputStream in = new BufferedInputStream(url.openStream(), 1024 * 4);
        ZipInputStream stream = new ZipInputStream(in);
        byte[] buffer = new byte[1024 * 4];

        ZipEntry entry;
        while((entry = stream.getNextEntry()) != null) {
            int read;
            String data = "";
            while((read = stream.read(buffer, 0, 1024 * 4)) >= 0) {
                data = new String(buffer, 0, read);
                sb.append(data);
            }
        }

        words = sb.toString().split("\n");
        StringBuilder changedString = new StringBuilder("");
        StringBuilder changedString2 = new StringBuilder("");
        boolean flag = false;
        for(String word : words) {
            trie.insert(word);
            if(word.equals("PEA"))
                flag = true;
            if(!flag)
                changedString.append(word + " ");
            else
                changedString2.append(word + " ");
        }
        System.out.println(changedString.toString());
        // compress
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream dos = new DeflaterOutputStream(bos);
            byte[] compressedArr = changedString.toString().getBytes();
            System.out.println("LENGTH : " + compressedArr.length);
            dos.write(compressedArr);
        } catch(Exception e) {
        }

        String encoded = new String(Base64.getEncoder().encode(bos.toByteArray()));
        System.out.println("String size : " + encoded.length());

        stream.close();
        in.close();
    }


    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode thisNode = this.root;

            for(int i = 0, n = word.length(); i < n; i++) {
                int idx = word.charAt(i) - 'A';
                if(thisNode.children[idx] == null) {
                    thisNode.children[idx] = new TrieNode();
                }
                thisNode = thisNode.children[idx];
            }
        }
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
    }
}
