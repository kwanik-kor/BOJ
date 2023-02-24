package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_26876_newTime {
    static final int HOUR = 60;
    static final int MAX = 60 * 24;

    static int[] visit = new int[MAX];

    static int solve(int start, int end) {
        Arrays.fill(visit, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == end) break;

            canMoveThenAdd(q, now, (now + 1) % MAX);
            canMoveThenAdd(q, now, (now + HOUR) % MAX);
        }

        return visit[end];
    }

    static void canMoveThenAdd(Queue<Integer> q, int originTime, int time) {
        if (visit[time] == -1) {
            q.add(time);
            visit[time] = visit[originTime] + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int start = changeStringToMinuteInt(br.readLine());
        int end = changeStringToMinuteInt(br.readLine());

        bw.write(solve(start, end) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int changeStringToMinuteInt(String line) {
        String[] arr = line.split(":");
        return Integer.parseInt(arr[0]) * HOUR + Integer.parseInt(arr[1]);
    }
}
