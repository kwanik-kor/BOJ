package floyd;

import java.io.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2224
 * 2. 풀이
 *  - 플로이드-와샬을 이용해 특정 명제가 참이라면 다음 노드로 계속해서 이동하는 방식으로 품
 *  - 대문자가 우선이기 때문에, 배열에 대문자를 앞으로 배치시킴
 *    > 최종 결과 print 시, 순차적으로 순회 시 자연스럽게 대문자가 앞에 오게 됨
 */
public class floyd_02224_proofProposition {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        map = new int[52][52];
        while(N-- > 0) {
            char[] proposition = br.readLine().toCharArray();
            map[charToIdx(proposition[0])][charToIdx(proposition[5])] = 1;
        }

        // Floyd
        for(int k = 0; k < 52; k++) {
            for(int i = 0; i < 52; i++) {
                for(int j = 0; j < 52; j++) {
                    if(map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        int cnt = 0;
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < 52; i++) {
            for(int j = 0; j < 52; j++) {
                if(map[i][j] == 1 && i != j) {
                    sb.append(String.format("%s => %s\n", idxToChar(i), idxToChar(j)));
                    cnt++;
                }
            }
        }

        bw.write(cnt + "\n" + sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int charToIdx(char a) {
        if('A' <= a && a <= 'Z')
            return a - 'A';

        return a - 'a' + 26;
    }

    static char idxToChar(int idx) {
        if(idx < 26)
            return (char)(idx + 'A');
        return (char)(idx - 26 + 'a');
    }

}
