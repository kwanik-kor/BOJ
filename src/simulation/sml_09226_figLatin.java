package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/9226
 */
public class sml_09226_figLatin {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String word = br.readLine();
            if (word.equals("#")) {
                break;
            }
            StringBuilder sb = new StringBuilder();

            Queue<Character> q = new ArrayDeque<>();
            int size = word.length();

            for (int i = 0; i < size; i++) {
                q.add(word.charAt(i));
            }

            while (size-- > 0) {
                char c = q.peek();
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    break;
                } else {
                    q.add(q.poll());
                }
            }

            while (!q.isEmpty()) {
                sb.append(q.poll());
            }
            sb.append("ay\n");

            bw.write(sb.toString());
        }
        bw.close();
        br.close();
    }

}
