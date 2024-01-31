import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static int testCase;
    public static int N;
    public static int cnt;

    public static int [][] snail;
    public static int [] dr = new int[] {0, 1, 0, -1};
    public static int [] dc = new int[] {1, 0, -1, 0};

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringTokenizer st;

    public static void move(int r, int c, int d) {
        snail[r][c] = cnt++;

        if (cnt == N * N + 1){
            return;
        }

        int nr = r + dr[d];
        int nc = c + dc[d];

        if(0 > nr || nr >= N || 0 > nc || nc >= N || snail[nr][nc] != 0){
            d = (d + 1) % 4;

            nr = r + dr[d];
            nc = c + dc[d];
        }

        move(nr, nc, d);
    }

    public static void solution() throws Exception {
        move(0, 0, 0);

        for(int [] arr : snail){
            for (int n : arr){
                bw.write(n + " ");
            }
            bw.newLine();
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            N = Integer.parseInt(br.readLine());
            snail = new int[N][N];
            cnt = 1;

            bw.write(String.format("#%d\n", t));
            solution();
        }

        bw.flush();
        bw.close();
    }
}