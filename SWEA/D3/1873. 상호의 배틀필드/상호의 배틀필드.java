import java.io.*;
import java.util.*;

public class Solution {

    static int testCase;
    static int H, W, N;

    static char [][] board;
    static char [] cmd;
    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};

    static int tr, tc;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int getDirection(char d){
        switch (d) {
            case '^' :
                return 0;
            case 'v' :
                return 1;
            case '<' :
                return 2;
            case '>' :
                return 3;
        }
        return -1;
    }

    public static char getDirection(int d){
        switch (d) {
            case 0 :
                return '^';
            case 1 :
                return 'v';
            case 2 :
                return '<';
            case 3 :
                return '>';
        }
        return ' ';
    }

    public static void move(int nd){
        board[tr][tc] = getDirection(nd);

        int nr = tr + dr[nd];
        int nc = tc + dc[nd];

        if(nr < 0 || H <= nr || nc < 0 || W <= nc || board[nr][nc] != '.'){
            return;
        }

        char tank = board[tr][tc];
        board[tr][tc] = '.';
        tr = nr;
        tc = nc;
        board[tr][tc] = tank;
    }

    public static boolean hit(int r, int c){
        char element = board[r][c];

        if(element == '*'){ // 벽돌 벽 -> 파괴 후 소멸
            board[r][c] = '.';
            return true;
        } else if (element == '#'){ // 강철 벽 -> 소멸
            return true;
        } else {
            return false;
        }
    }

    public static void fire(){
        int direction = getDirection(board[tr][tc]);

        if(direction < 2){ // U, D
            for(int i = 1; i <= H; i++){
                int nr = tr + dr[direction] * i;
                if(nr < 0 || H <= nr || hit(nr, tc)){
                    break;
                }
            }
        } else { // L, R
            for(int i = 1; i <= W; i++){
                int nc = tc + dc[direction] * i;
                if(nc < 0 || W <= nc || hit(tr, nc)){
                    break;
                }
            }
        }
    }

    public static void solution(int tc) throws IOException {
        for(int i = 0; i < N; i++){
            switch (cmd[i]) {
                case 'U' :
                    move(0);
                    break;
                case 'D' :
                    move(1);
                    break;
                case 'L' :
                    move(2);
                    break;
                case 'R' :
                    move(3);
                    break;
                case 'S' :
                    fire();
                    break;
            }
        }

        bw.write(String.format("#%d ", tc));
        for(int i = 0; i < H; i++){
            bw.write(board[i]);
            bw.write("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            board = new char [H][W];
            for(int i = 0; i < H; i++){
                char [] inp = br.readLine().toCharArray();
                for(int j = 0; j < W; j++){
                    board[i][j] = inp[j];

                    if(inp[j] == '<' || inp[j] == '>' || inp[j] == '^' || inp[j] == 'v'){
                        tr = i;
                        tc = j;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            cmd = br.readLine().toCharArray();

            solution(t);
        }

        bw.close();
    }
}
