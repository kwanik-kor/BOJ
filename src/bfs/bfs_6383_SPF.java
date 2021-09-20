package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bfs_6383_SPF {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int network = 1;
        while(true) {
            String line = "";
            int nodeCnt = 0;
            while(true) {
                line = br.readLine();
                if(line.equals("0"))
                    break;
                StringTokenizer st = new StringTokenizer(line);
                nodeCnt++;
            }

            if(nodeCnt == 0)
                break;
            network++;
            br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
