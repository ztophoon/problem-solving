import java.io.*;
import java.util.*;

/*
 * 회사 좌표(0번 idx)를 고객 좌표(1번 idx ~)와 같은 배열에서 관리하고,
 * 이후에 다시 확인하지 않는 방식으로 dfs 구현
 * 모든 고객을 방문했을 당시의 누적 이동경로와 집까지의 거리를 합산하고, 이 값의 최솟값을 관리한다.
 */

public class Solution {

    static int testCase;

    static int N, hx, hy, answer;  // 고객 수, 집 x좌표, 집 y좌표, 정답
    static int [] xs, ys, visited; // 고객 x좌표 배열, 고객 y좌표 배열, 방문 확인 배열

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int getDistance(int ax, int ay, int bx, int by){ // 인자로 받은 두 좌표 간의 거리를 반환
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }

    public static void dfs(int cnt, int idx, int d) { // 현재까지 방문한 고객 수, 현재 방문한 고객 인덱스, 현재까지 총 이동 거리
        if(cnt == N){ // 모든 고객을 방문했을 때,
            answer = Math.min(answer, d + getDistance(xs[idx], ys[idx], hx, hy)); // 총 이동 경로와 마지막 고객으로 부터 집 까지의 거리를 합하여 정답과 비교해 최솟값 유지
            return;
        }

        for(int i = 1; i <= N; i++){
            if(visited[i] == 1){ // 이미 방문한 고객은 방문하지 않음
                continue;
            }

            visited[i] = 1; // 방문 표시
            dfs(cnt + 1, i, d + getDistance(xs[idx], ys[idx], xs[i], ys[i])); // 현재 좌표에서 탐색 할 좌표의 거리를 구한 후 인자로 넘겨 재귀 탐색
            visited[i] = 0; // Backtracking
        }
    }

    public static void main(String[] args) throws IOException {
        testCase = Integer.parseInt(br.readLine()); // 테스트케이스 입력

        for (int t = 1; t <= testCase; t++) {
            answer = Integer.MAX_VALUE; // 정답을 정수 최댓값으로 초기화

            N = Integer.parseInt(br.readLine()); // 고객 수 입력
            xs = new int [N + 1];      // 고객 x 좌표 배열 초기화
            ys = new int [N + 1];      // 고객 y 좌표 배열 초기화
            visited = new int [N + 1]; // 방문 확인 배열 초기화

            st = new StringTokenizer(br.readLine());
            xs[0] = Integer.parseInt(st.nextToken()); // 회사 x 좌표를 고객 x 좌표 배열에 미리 저장
            ys[0] = Integer.parseInt(st.nextToken()); // 회사 y 좌표를 고객 y 좌표 배열에 미리 저장
            hx = Integer.parseInt(st.nextToken());    // 집 x 좌표 저장
            hy = Integer.parseInt(st.nextToken());    // 집 y 좌표 저장

            for(int i = 1; i <= N; i++){
                xs[i] = Integer.parseInt(st.nextToken()); // 고객 x 좌표 입력
                ys[i] = Integer.parseInt(st.nextToken()); // 고객 y 좌표 입력
            }

            dfs(0, 0, 0); // 재귀 호출 시작

            bw.write(String.format("#%d %d\n", t, answer)); // 결과 버퍼 저장
        }

        bw.close(); // 버퍼 출력
    }
}
