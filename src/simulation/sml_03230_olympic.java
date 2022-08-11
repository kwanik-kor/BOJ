package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/3230
 */
public class sml_03230_olympic {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] rank = new int[N + 1];
        Arrays.fill(rank, 1);
        for (int i = 1; i <= N; i++) {
            int newRank = Integer.parseInt(br.readLine());
            rank[i] = newRank;
            for (int j = 1; j <= N; j++) {
                if (i != j && rank[j] >= newRank) {
                    rank[j]++;
                }
            }
        }

        int[] mPlayers = IntStream.rangeClosed(1, N)
                        .filter(i -> rank[i] <= M)
                        .boxed()
                        .sorted((a, b) -> Integer.compare(rank[b], rank[a]))
                        .mapToInt(Integer::intValue)
                        .toArray();

        for (int i = 0; i < M; i++) {
            rank[mPlayers[i]] = 1;
        }

        for (int i = 0; i < M; i++) {
            int newRank = Integer.parseInt(br.readLine());
            rank[mPlayers[i]] = newRank;
            for (int j = 0; j < M; j++) {
                if (mPlayers[i] != mPlayers[j] && rank[mPlayers[j]] >= newRank) {
                    rank[mPlayers[j]]++;
                }
            }
        }

        int[] finalResult = IntStream.of(mPlayers)
                        .filter(a -> rank[a] <= 3)
                        .boxed()
                        .sorted((a, b) -> Integer.compare(rank[a], rank[b]))
                        .mapToInt(Integer::intValue)
                        .toArray();

        for (int i = 0; i < 3; i++) {
            bw.write(finalResult[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
