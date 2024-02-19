import java.io.*;
import java.util.*;

/*
 * 방문한 알파벳을 정수로 변환한 인덱스를 통해 방문 배열 관리
 * e.g. 'A' = 65, ..., 'Z' = '89'
 * DFS와 백트래킹을 통해 가장 깊게 방문할 수 있는 경우 탐색
 */

public class Main {

    public static int R, C, answer; // 행 개수, 열 개수, 정답
    public static char [][] board;  // 입력 문자 배열
    public static int [] visited;   // 방문 확인 배열

    public static int [] dr = {-1, 1, 0, 0}; // 행 delta
    public static int [] dc = {0, 0, -1, 1}; // 열 delta

    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int r, int c, int cnt) {
        for(int d = 0; d < 4; d++){
            int nr = r + dr[d]; // 탐색 행 계산
            int nc = c + dc[d]; // 탐색 열 계산

            if(nr < 0 || R <= nr || nc < 0 || C <= nc || visited[board[nr][nc]] == 1){ // 유효 행, 열 범위 확인 + 방문 여부 확인
                continue;
            }

            visited[board[nr][nc]] = 1; // 방문 추가
            dfs(nr, nc, cnt + 1); // 재귀 탐색
            visited[board[nr][nc]] = 0; // 백트래킹
        }

        answer = Math.max(answer, cnt); // 더 이상 탐색 불가능 할 때, 최대값 갱신
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 행 개수 입력
        C = Integer.parseInt(st.nextToken()); // 열 개수 입력

        visited = new int [91];  // 방문 확인 배열 초기화 : 65 ~ 90 까지만 사용
        board = new char [R][C]; // 문자열 배열 초기화
        for(int r = 0; r < R; r++){
            board[r] = br.readLine().toCharArray(); // 문자열 배열 입력
        }

        visited[board[0][0]] = 1; // 초기 탐색 문자열 방문 표시
        dfs(0, 0, 1);  // 초기 탐색

        bw.write(answer + ""); // 정답 버퍼 입력
        bw.close(); // 정답 버퍼 출력
    }
}
