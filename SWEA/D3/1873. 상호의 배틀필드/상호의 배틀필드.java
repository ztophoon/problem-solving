import java.io.*;
import java.util.*;

public class Solution {

    static int testCase;
    static int H, W, N; // 필드 높이, 필드 너비, 명령 길이

    static char [][] board; // 필드 상태 저장 배열
    static char [] cmd;     // 명령 저장 배열
    static int [] dr = {-1, 1, 0, 0}; // 행 delta
    static int [] dc = {0, 0, -1, 1}; // 열 delta

    static int tr, tc; // 탱크의 현재 위치 행, 열 좌표

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int getDirection(char d){ // 탱크의 방향 문자열 -> 탱크의 방향 인덱스 변환
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

    public static char getDirection(int d){ // 탱크의 방향 인덱스 -> 탱크의 방향 문자열 변환
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

    public static void move(int nd){ // 탱크 이동 함수
        board[tr][tc] = getDirection(nd); // 주어진 방향 nd로 탱크의 방향을 수정

        int nr = tr + dr[nd]; // 이동할 행 좌표
        int nc = tc + dc[nd]; // 이동할 열 좌표

        if(nr < 0 || H <= nr || nc < 0 || W <= nc || board[nr][nc] != '.'){ // 이동할 좌표가 유효 범위 내에 없거나, 이동이 불가능한 칸인지 판단
            return;
        }

        char tank = board[tr][tc]; // 탱크의 위치 swap을 위해 탱크의 상태 임시 저장
        board[tr][tc] = '.'; // 탱크 이동 후 원래 위치 평지화
        tr = nr; // 현재 탱크 행 좌표 수정
        tc = nc; // 현재 탱크 열 좌표 수정
        board[tr][tc] = tank; // 탱크 이동 후 위치에 탱크 상태 저장
    }

    public static boolean hit(int r, int c){ // r, c 위치에 포탄이 도달한 경우를 처리
        char element = board[r][c]; // r, c 좌표에 있는 요소 저장

        if(element == '*'){ // 벽돌 벽이 있는 경우 -> 파괴 후 소멸
            board[r][c] = '.'; // 벽돌 파괴 후 평지화
            return true; // 포탄 소멸
        } else if (element == '#'){ // 강철 벽이 있는 경우 -> 소멸
            return true; // 포탄 소멸
        } else {
            return false; // 포탄 소멸되지 않음
        }
    }

    public static void fire(){ // 탱크의 포탄 발사 과정을 처리
        int direction = getDirection(board[tr][tc]); // 탱크의 방향 인덱스

        if(direction < 2){ // 현재 방향이 U 또는 D인 경우 -> 행 단위 발사
            for(int i = 1; i <= H; i++){
                int nr = tr + dr[direction] * i; // 발사된 포탄의 새로운 행 좌표
                if(nr < 0 || H <= nr || hit(nr, tc)){ // 포탄이 유효 범위를 벗어나거나, 소멸하면 중지
                    break;
                }
            }
        } else { // 현재 방향이 L 또는 R인 경우 -> 열 단위 발사
            for(int i = 1; i <= W; i++){
                int nc = tc + dc[direction] * i; // 발사된 포탄의 새로운 열 좌표
                if(nc < 0 || W <= nc || hit(tr, nc)){ // 포탄이 유효 범위를 벗어나거나, 소멸하면 중지
                    break;
                }
            }
        }
    }

    public static void solution(int tc) throws IOException {
        for(int i = 0; i < N; i++){
            switch (cmd[i]) { // 각 명령에 대한 동작 수행
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

        // 결과 버퍼 입력
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
            H = Integer.parseInt(st.nextToken()); // 필드 높이 입력
            W = Integer.parseInt(st.nextToken()); // 필드 너비 입력

            board = new char [H][W];
            for(int i = 0; i < H; i++){
                char [] inp = br.readLine().toCharArray(); // 필드 요소 입력
                for(int j = 0; j < W; j++){
                    board[i][j] = inp[j]; // 필드 배열에 각 요소 저장

                    if(inp[j] == '<' || inp[j] == '>' || inp[j] == '^' || inp[j] == 'v'){ // 입력 요소가 탱크인 경우
                        tr = i; // 현재 탱크의 행 좌표 저장
                        tc = j; // 현재 탱크의 열 좌표 저장
                    }
                }
            }

            N = Integer.parseInt(br.readLine()); // 명령어 길이 입력
            cmd = br.readLine().toCharArray();   // 명령어 입력

            solution(t);
        }

        bw.close(); // 버퍼 출력
    }
}
