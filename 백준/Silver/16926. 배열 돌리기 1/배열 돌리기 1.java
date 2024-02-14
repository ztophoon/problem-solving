import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static int [][] board;
    static int [][] newBoard;
    static int [][] visited;

    static int [] dr = {1, 0, -1, 0};
    static int [] dc = {0, 1, 0, -1};

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void next(int d, int r, int c){
        visited[r][c] = 1;

        int nr = r + dr[d];
        int nc = c + dc[d];

        if (d == 3 && visited[nr][nc] == 1) {
            newBoard[nr][nc] = board[r][c];

            d = 0;
            nr = r + dr[d];
            nc = c + dc[d];
        } else if (nr < 0 || N <= nr || nc < 0 || M <= nc || visited[nr][nc] == 1){
            d++;
            nr = r + dr[d];
            nc = c + dc[d];

            newBoard[nr][nc] = board[r][c];
        } else {
            newBoard[nr][nc] = board[r][c];
        }

        if(visited[nr][nc] == 0){
            next(d, nr, nc);
        }
    }

    static void rotate() {
        newBoard = new int[N][M];
        visited = new int[N][M];

        next(0, 0, 0);

        board = Arrays.copyOf(newBoard, newBoard.length);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(R-- > 0){
            rotate();
        }

        for(int [] row : board){
            for(int n : row) {
                bw.write(n + " ");
            }
            bw.newLine();
        }
        bw.close();
    }
}
