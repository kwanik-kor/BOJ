package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/16959
 */
public class bfs_16959_chessTravel {

    static int N;
    static int[][] map;
    static boolean[][][][] visit;

    static int solve(int startY, int startX) {
        int ret = Integer.MAX_VALUE;

        Queue<ChessPiece> q = new LinkedList<>();

        for (int type = 0; type < 3; type++) {
            q.add(new ChessPiece(startY * N  + startX, type, 0, 1));
            visit[startY][startX][1][type] = true;
        }

        while (!q.isEmpty()) {
            ChessPiece now = q.poll();
            int y = now.pos / N;
            int x = now.pos % N;

            if (now.current == N * N) {
                ret = Math.min(ret, now.count);
                continue;
            }

            // 말 교체
            for (ChessPieceType type : ChessPieceType.values()) {
                if (now.getType() == type || visit[y][x][now.current][type.getIdx()]) continue;
                visit[y][x][now.current][type.getIdx()] = true;
                q.add(new ChessPiece(now.pos, type.getIdx(), now.count + 1, now.current));
            }

            ChessPieceType type = now.getType();
            if (type == ChessPieceType.KNIGHT) {
                for (int dir = 0; dir < 8; dir++) {
                    int ny = y + type.getDy()[dir];
                    int nx = x + type.getDx()[dir];

                    ChessPiece next = canContinueThenGetNextNode(ny, nx, now.current, type.getIdx(), now.count);
                    if (next != null) {
                        q.add(next);
                    }
                }
            } else if (now.getType() == ChessPieceType.ROOK) {
                for (int dir = 0; dir < 4; dir++) {
                    for (int offset = 1; offset < N; offset++) {
                        int ny = y + type.getDy()[dir] * offset;
                        int nx = x + type.getDx()[dir] * offset;

                        ChessPiece next = canContinueThenGetNextNode(ny, nx, now.current, type.getIdx(), now.count);
                        if (next != null) {
                            q.add(next);
                        }
                    }
                }
            } else {
                for (int dir = 0; dir < 4; dir++) {
                    for (int offset = 1; offset < N; offset++) {
                        int ny = y + type.getDy()[dir] * offset;
                        int nx = x + type.getDx()[dir] * offset;

                        ChessPiece next = canContinueThenGetNextNode(ny, nx, now.current, type.getIdx(), now.count);
                        if (next != null) {
                            q.add(next);
                        }
                    }
                }
            }

        }

        return ret;
    }

    static ChessPiece canContinueThenGetNextNode(int ny, int nx, int current, int typeIdx, int count) {
        if (isOutOfRange(ny, nx)) return null;
        if (map[ny][nx] == current + 1) {
            current++;
        }
        if (visit[ny][nx][current][typeIdx]) return null;

        visit[ny][nx][current][typeIdx] = true;
        return new ChessPiece(ny * N + nx, typeIdx, count + 1, current);
    }

    static boolean isOutOfRange(int y, int x) {
        return y < 0 || x < 0 || N <= y || N <= x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N][N * N + 1][3];

        int y = 0, x = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    y = i;
                    x = j;
                }
            }
        }

        int ans = solve(y, x);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class ChessPiece {
        int pos, type, count, current;

        public ChessPiece(int pos, int type, int count, int current) {
            this.pos = pos;
            this.type = type;
            this.count = count;
            this.current = current;
        }

        ChessPieceType getType() {
            return ChessPieceType.getType(this.type);
        }
    }

    enum ChessPieceType {
        KNIGHT(0, new int[]{-1, -2, -2, -1, 1, 2, 2, 1}, new int[]{-2, -1, 1, 2, 2, 1, -1, -2}),
        ROOK(1, new int[]{-1, 0, 1, 0}, new int[]{0, 1, 0, -1}),
        BISHOP(2, new int[]{-1, -1, 1, 1}, new int[]{-1, 1, -1, 1});

        final int idx;
        final int[] dy;
        final int[] dx;

        ChessPieceType(int idx, int[] dy, int[] dx) {
            this.idx = idx;
            this.dy = dy;
            this.dx = dx;
        }

        public int[] getDy() {
            return dy;
        }

        public int[] getDx() {
            return dx;
        }

        public int getIdx() {
            return idx;
        }

        static ChessPieceType getType(int idx) {
            if (idx == 0) return KNIGHT;
            if (idx == 1) return ROOK;
            return BISHOP;
        }
    }
}
