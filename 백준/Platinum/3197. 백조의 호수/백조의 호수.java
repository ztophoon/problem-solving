import java.io.*;
import java.util.*;

public class Main {

    static int R, C, answer;
    static int m1r, m1c, m2r, m2c;

    static int ice;
    static int [][] board;
    static int [][] visited;

    static Queue <int[]> iceQ = new ArrayDeque<>();

    static int [] dr = {1, 0, 0, -1};
    static int [] dc = {0, 1, -1, 0};

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean findLove(int day, int r, int c) {
        visited[r][c] = 1;

        if(r == m2r && c == m2c) {
            return true;
        }

        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || R <= nr || nc < 0 || C <= nc || board[nr][nc] > day || visited[nr][nc] == 1) {
                continue;
            }

            if(findLove(day, nr, nc)){
                return true;
            }
        }

        return false;
    }

    public static boolean meeting(int day) {
        visited = new int[R][C];
        return findLove(day, m1r, m1c);
    }

    public static void melting(int day) {
        Queue<int[]> nextIceQ = new ArrayDeque<>();

        while(!iceQ.isEmpty()){
            int [] now = iceQ.poll();
            int r = now[0];
            int c = now[1];

            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || R <= nr || nc < 0 || C <= nc || board[nr][nc] != 0) {
                    continue;
                }

                board[nr][nc] = day + 1;
                ice--;

                nextIceQ.add(new int[] {nr, nc});
            }
        }

        iceQ = nextIceQ;
    }

    public static void solution() throws IOException {
        int day = 1;
        while(ice > 0){
            melting(day++);
        }

        int now = 1;
        while(now <= day){
            int mid = (now + day) / 2;
            if(meeting(mid)) {
                day = mid - 1;
            } else {
                now = mid + 1;
            }
        }

        answer = now - 1;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ice = R * C - 2;
        board = new int [R][C];
        ArrayList<int []> manLi = new ArrayList<>();

        for(int r = 0; r < R; r++) {
            char [] inp = br.readLine().toCharArray();
            for(int c = 0; c < C; c++) {
                if(inp[c] == '.'){
                    iceQ.add(new int [] {r, c});
                    board[r][c] = 1;
                    ice--;
                }
                if(inp[c] == 'L') {
                    iceQ.add(new int [] {r, c});
                    board[r][c] = 1;
                    manLi.add(new int [] {r, c});
                }
            }
        }

        m1r = manLi.get(0)[0];
        m1c = manLi.get(0)[1];
        m2r = manLi.get(1)[0];
        m2c = manLi.get(1)[1];

        solution();

        bw.write(Integer.toString(answer));
        bw.close();
    }
}
