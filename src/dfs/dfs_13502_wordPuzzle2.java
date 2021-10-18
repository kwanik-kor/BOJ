package dfs;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class dfs_13502_wordPuzzle2 {

    static final int SIZE = 5;

    static int ans = 0;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    static boolean[][] visit = new boolean[SIZE][SIZE];
    static char[][] puzzle = new char[SIZE][SIZE];


    public static void main(String[] args) throws IOException, DataFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = getAndCompressString();
        System.out.println(word);
//        System.out.println("COMPRESSED STRING LENGTH: " + word.length());
//        decompressAndSetTrie(word);
        bw.flush();
        bw.close();
        br.close();
    }

    static String getAndCompressString() throws IOException {
        URL url = new URL("https://d2gd6pc034wcta.cloudfront.net/data/1165.zip");
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

        String ret = sb.toString().replaceAll("\n", " ");

        // 1. First Way - failed cause of long length of string
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        OutputStream out = new DeflaterOutputStream(bos);
//        out.write(ret.getBytes(StandardCharsets.UTF_8));
//        out.close();
//        byte[] compressedArr = bos.toByteArray();
//
//        StringBuilder stb = new StringBuilder();
//        for(byte b : compressedArr) {
//            stb.append(String.format("%02X", b));
//        }
//        return stb.toString();

        // 2. Second Way
        Deflater def = new Deflater(9);
        byte[] sbytes = ret.getBytes(StandardCharsets.UTF_8);
        def.setInput(sbytes);
        def.finish();

        byte[] buf = new byte[sbytes.length];
        int n = def.deflate(buf);

        return new String(buf, 0, n, StandardCharsets.ISO_8859_1) + "*" + sbytes.length;
    }

    static void decompressAndSetTrie(String compressedString) throws DataFormatException {
        int pos = compressedString.lastIndexOf('*');
        int len = Integer.parseInt(compressedString.substring(pos + 1));
        compressedString = compressedString.substring(0, pos);

        Inflater inf = new Inflater();
        byte[] buffer = compressedString.getBytes(StandardCharsets.ISO_8859_1);
        byte[] decomp = new byte[len];
        inf.setInput(buffer);
        inf.inflate(decomp, 0, len);
        inf.end();

        String result = new String(decomp, StandardCharsets.UTF_8);
        System.out.println(result);
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
