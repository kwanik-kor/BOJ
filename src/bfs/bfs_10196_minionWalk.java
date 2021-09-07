package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1. 문제링크 : https://www.acmicpc.net/problem/10196
 * 2. 풀이
 *  - 그냥 경로 찾기...
 */
public class bfs_10196_minionWalk {

    /* This function solves the MinionWalk problem. It takes as input
     * a 2-dimensional array of chars, representing the available ('O')
     * and occupied ('X') locations in the room. For example:
     *
     * Input array:
     *   O X O O
     *   O O X O
     *   X X O O
     *   O O O X
     *   O O O O
     *
     * Your code needs to find locations that can be reached by
     * minions walking around the room, starting from the top left
     * corner. Minions can only move up, down, left, and right.
     * I.e., no diagonal moves.
     *
     * Your code should change array values to 'M' if minions
     * can walk to that location. It should return true if
     * minions can walk across to the bottom right corner of
     * the room, and false otherwise.
     */
    static final char MINION = 'M';
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    private static boolean canReach(char[][] wall)
    {
        /* -------------------- INSERT CODE HERE ----------------------*/

        int nRows = wall.length;			// number of rows
        int nCols = wall[0].length;			// number of columns

        if(wall[0][0] == 'X')
            return false;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        wall[0][0] = MINION;
        while(!q.isEmpty()) {
            int now = q.poll();
            int y = now / nCols;
            int x = now % nCols;
            for(int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if(ny < 0 || nx < 0 || nRows <= ny || nCols <= nx || wall[ny][nx] != 'O') continue;
                wall[ny][nx] = MINION;
                q.add(ny * nCols + nx);
            }
        }

        return wall[nRows - 1][nCols - 1] == MINION;
    }

    /* --------------------- END OF INSERTION ---------------------*/

    /**
     *  Pretty print the wall
     */
    private static void prettyPrintWall(char[][] wall)
    {
        int nRows = wall.length;
        int nCols = wall[0].length;

        for (int j = 0; j < nCols; j++) {	// print top boundary
            System.out.print("+---");
        }
        System.out.println("+");

        for (int i = 0; i < nRows; i++) {
            // print row contents
            for (int j = 0; j < nCols; j++) {
                switch (wall[i][j]) {
                    case 'X':
                        System.out.print("| X "); break;
                    case 'O':
                        System.out.print("|   "); break;
                    case 'M':
                        System.out.print("| M "); break;

                }
            }
            System.out.println("|");
            // print row separator
            for (int j = 0; j < nCols; j++) {
                switch (wall[i][j]) {
                    case 'X':
                    case 'O':
                    case 'M':
                        System.out.print("+---"); break;
                }
            }
            System.out.println("+");
        }
    }

    /**
     *  Main Program
     */
    public static void main(String[] args) throws Exception {
        // read input
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for(int t = 1; t <= numCases; t++) {
            int nRows = scanner.nextInt();	// number of rows in wall
            int nCols = scanner.nextInt();	// number of columns in wall
            scanner.nextLine();				// skip to eol
            char[][] wall = new char[nRows][]; // the wall
            for (int i = 0; i < nRows; i++) {
                wall[i] = new char[nCols];
                String line = scanner.nextLine();
                for (int j = 0; j < nCols; j++) {
                    wall[i][j] = line.charAt(j);
                }
            }

            System.out.println("Case: " + t);// echo input

            boolean result = canReach(wall);					// check for solution
            prettyPrintWall(wall);			 // print the reachable parts of the room

            String outputMessage = result ? "can" : "cannot";		// choose output
            System.out.format("Minions %s cross the room %n", outputMessage);
        }
        scanner.close();					// close input stream
    }
}
