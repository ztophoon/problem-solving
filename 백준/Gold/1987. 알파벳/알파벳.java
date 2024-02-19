import java.io.*;
import java.util.*;

public class Main {

    public static int R, C, answer;
    public static char [][] board;
    public static int [] visited;

    public static int [] dr = {-1, 1, 0, 0};
    public static int [] dc = {0, 0, -1, 1};

    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int r, int c, int cnt) {
        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || R <= nr || nc < 0 || C <= nc || visited[board[nr][nc]] == 1){
                continue;
            }

            visited[board[nr][nc]] = 1;
            dfs(nr, nc, cnt + 1);
            visited[board[nr][nc]] = 0;
        }

        answer = Math.max(answer, cnt);
    }

    public static void solution() throws IOException {
        visited[board[0][0]] = 1;
        dfs(0, 0, 1);

        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new int [100];
        board = new char [R][C];
        for(int r = 0; r < R; r++){
            board[r] = br.readLine().toCharArray();
        }

        solution();

        bw.close();
    }
}
