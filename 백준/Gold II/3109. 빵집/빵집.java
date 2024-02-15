import java.io.*;
import java.util.*;

public class Main {

    public static int R, C, answer;
    public static int [][] board;

    public static int [] dr = {-1, 0, 1};
    public static int [] dc = {1, 1, 1};

    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean dfs(int cr, int cc) {
        board[cr][cc] = 'O';

        if(cc == C - 2){
            answer++;
            return true;
        }

        for(int d = 0; d < 3; d++){
            int nr = cr + dr[d];
            int nc = cc + dc[d];

            if(nr < 0 || R <= nr || nc < 0 || C <= nc || board[nr][nc] != '.'){
                continue;
            }

            if(dfs(nr, nc)){
                return true;
            }
        }

        return false;
    }

    public static void solution() throws IOException {
        for(int r = 0; r < R; r++) {
            if(board[r][1] == '.'){
                dfs(r, 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int [R][C];

        for(int r = 0; r < R; r++){
            char [] inp = br.readLine().toCharArray();
            for(int c = 0; c < C; c++){
                board[r][c] = inp[c];
            }
        }

        solution();

        bw.write(answer + "");
        bw.close();
    }
}
