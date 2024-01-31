import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static boolean isCycle;

    public static char [][] board;

    public static int [][] visited;
    public static int [][] globalVisted;

    public static int[] dr = new int[] {0, 1, 0, -1};
    public static int[] dc = new int[] {1, 0, -1, 0};

    public static void dfs(int r, int c, char color, int prevDirection){

        int nr, nc;
        for(int d = 0; d < 4; d++){
            if(Math.abs(prevDirection - d) == 2){
                continue;
            }

            nr = r + dr[d];
            nc = c + dc[d];
            if(nr < 0 || N <= nr || nc < 0 || M <= nc){
                continue;
            }

            if(visited[nr][nc] == 1){
                isCycle = true;
                return;
            }

            if(board[nr][nc] == color){
                globalVisted[nr][nc] = 1;
                visited[nr][nc] = 1;
                dfs(nr, nc, color, d);
                visited[nr][nc] = 0;
            }
        }
    }

    public static String solution() {

        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                if(globalVisted[r][c] == 0){
                    globalVisted[r][c] = 1;

                    visited = new int[N][M];
                    visited[r][c] = 1;

                    dfs(r, c, board[r][c], 0);
                }
                if(isCycle) {
                    return "Yes";
                }
            }
        }

        return "No";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        globalVisted = new int[N][M];

        char [] chars;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            chars = st.nextToken().toCharArray();
            for(int j = 0; j < M; j++){
                board[i][j] = chars[j];
            }
        }

        bw.write(solution());
        bw.newLine();

        bw.flush();
        bw.close();
    }
}
