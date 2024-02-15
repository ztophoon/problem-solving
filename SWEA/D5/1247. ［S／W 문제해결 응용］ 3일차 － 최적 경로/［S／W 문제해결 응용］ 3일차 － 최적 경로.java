import java.io.*;
import java.util.*;

public class Solution {

    static int testCase;

    static int N, hx, hy, answer;
    static int [] xs, ys, visited;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int getDistance(int ax, int ay, int bx, int by){
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }

    public static void dfs(int cnt, int idx, int d) {
        if(cnt == N + 1){
            answer = Math.min(answer, d + getDistance(xs[idx], ys[idx], hx, hy));
            return;
        }

        for(int i = 1; i <= N; i++){
            if(visited[i] == 1){
                continue;
            }

            visited[i] = 1;
            dfs(cnt + 1, i, d + getDistance(xs[idx], ys[idx], xs[i], ys[i]));
            visited[i] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            answer = Integer.MAX_VALUE;

            N = Integer.parseInt(br.readLine());
            xs = new int [N + 1];
            ys = new int [N + 1];
            visited = new int [N + 1];

            st = new StringTokenizer(br.readLine());
            xs[0] = Integer.parseInt(st.nextToken());
            ys[0] = Integer.parseInt(st.nextToken());
            hx = Integer.parseInt(st.nextToken());
            hy = Integer.parseInt(st.nextToken());

            for(int i = 1; i <= N; i++){
                xs[i] = Integer.parseInt(st.nextToken());
                ys[i] = Integer.parseInt(st.nextToken());
            }

            dfs(1, 0, 0);

            bw.write(String.format("#%d %d\n", t, answer));
        }

        bw.close();
    }
}
