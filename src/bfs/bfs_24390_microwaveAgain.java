package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/24390
 * 2. 풀이
 *  - 단순한 BFS 문제
 *   - 단, 노드에 조리시작 버튼 선택 여부를 추가해 최종적으로 한 번 더 해줄지 말지를 결정한다.
 *  - Greedy가 더 효율적일 것으로 보이는 문제
 */
public class bfs_24390_microwaveAgain {

    static final int MAX = 3600;
    static int time = 0;

    static boolean[] visit;
    static int[] button = {10, 30, 60, 600};

    static int search() {
        int cnt = 0;

        Queue<Microwave> q = new LinkedList<Microwave>();
        q.add(new Microwave(0, false));
        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                Microwave now = q.poll();
                if(now.time == time) {
                    return now.onCook? cnt : (cnt + 1);
                }

                for(int i = 0; i < 4; i++) {
                    int nextT = now.time + button[i];
                    if(MAX < nextT || visit[nextT]) continue;
                    visit[nextT] = true;
                    if(i == 1 && !now.onCook) {
                        q.add(new Microwave(nextT, true));
                    } else {
                        q.add(new Microwave(nextT, now.onCook));
                    }
                }
            }

            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(":");
        time += Integer.parseInt(input[0]) * 60;
        time += Integer.parseInt(input[1]);

        visit = new boolean[3601];

        bw.write(search() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Microwave {
        int time;
        boolean onCook;
        public Microwave(int time, boolean onCook) {
            this.time = time;
            this.onCook = onCook;
        }
    }

}
