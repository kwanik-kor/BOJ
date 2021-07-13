package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/17135
 * 2. 풀이
 *  - 단순 시뮬레이션으로 문제의 조건을 잘 풀어내면 가능
 *  - 조합으로 궁수의 위치를 선택 > 15 C 3 >> max 455 >>> 쌉가능
 *  - 선택한 궁수 위치를 기반으로 최대 N개의 턴 동안 공격할 수 있는 적들을 섬멸해감
 */
public class bfs_17135_castleDefence {

    static final int ARCHER = 3;
    static int N, M, D;

    static int ans = 0;
    static int enemyCnt;
    static List<Point> enemies;

    static void comb(boolean[] arr, int start, int r) {
        if(r == ARCHER) {
            // Do Something on Here!
            List<Integer> archer = new ArrayList<>();
            for(int i = 0; i < arr.length; i++) {
                if(arr[i])
                    archer.add(i);
            }
            defence(archer);
            return;
        }
        for(int i = start; i < M; i++) {
            arr[i] = true;
            comb(arr, i + 1, r + 1);
            arr[i] = false;
        }
    }

    static void defence(List<Integer> archer) {
        // 최종 공격 당한 적의 set
        Set<Integer> attacked = new HashSet<>();

        // 총 진행 가능한 턴 수
        for(int n = 1; n <= N; n++) {
            Set<Integer> tempSet = new HashSet<>();

            // Archer
            // 궁수는 동일한 적을 공격할 수 있음
            for(Integer arch : archer) {
                Point attack = null;
                int dist = Integer.MAX_VALUE;
                int tempX = Integer.MAX_VALUE;

                for(Point enemy : enemies) {
                    // 이미 밀려나간 적이거나, 한 턴에서 제거된 적인 경우
                    if(N - n < enemy.y || attacked.contains(enemy.y * M + enemy.x))
                        continue;

                    // 한 칸씩 밀려나기 때문에 위로 한줄 씩 올리기 위해서 n을 빼줌
                    int tempDist = getDist(N + 1, arch, enemy.y, enemy.x) - n;
                    if(D < tempDist) // 공격할 수 없는 적인 경우
                        continue;

                    if(tempDist < dist) {
                        dist = tempDist;
                        tempX = enemy.x;
                        attack = new Point(enemy.y, enemy.x);
                    } else if(tempDist == dist && enemy.x < tempX) {
                        tempX = enemy.x;
                        attack = new Point(enemy.y, enemy.x);
                    }
                }

                if(attack != null) {
                    tempSet.add(attack.y * M + attack.x);
                }

            }

            attacked.addAll(tempSet);
        }

        ans = Math.max(ans, attacked.size());
    }

    static int getDist(int y1, int x1, int y2, int x2) {
        return Math.abs(y1 - y2) + Math.abs(x1 - x2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        enemies = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a == 1)
                    enemies.add(new Point(i, j));
            }
        }
        enemyCnt = enemies.size();

        comb(new boolean[M], 0, 0);

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
