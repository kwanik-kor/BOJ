package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16431
 */
public class math_16431_bessieAndDaisy {

    static Node bessie, daisy, john;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bessie = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        daisy = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        john = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int dist_daisy = Math.abs(john.y - daisy.y) + Math.abs(john.x - daisy.x);
        int dist_bessie = Math.max(Math.abs(john.y - bessie.y), Math.abs(john.x - bessie.y));

        bw.write(dist_bessie == dist_daisy? "tie" : (dist_bessie < dist_daisy ? "bessie" : "daisy"));
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int y, x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
