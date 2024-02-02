import java.io.*;
import java.util.*;

/*
 * [암호생성기]
 * - 고정된 크기의 큐를 순회하면서 1 ~ 5를 반복적으로 빼준다.
 * - 빼준 값이 0 이하이면 0으로 세팅해서 값을 다시 넣고, 반복을 종료한다.
 */

public class Solution {

    public static int testCase = 10; // 테스트케이스 개수 고정
    public static int N = 8;         // 큐의 크기 고정

    public static Queue<Integer> q = new ArrayDeque<>(); // 정수를 저장할 큐

    public static BufferedReader br;  // 입력을 받기 위한 버퍼리더
    public static BufferedWriter bw;  // 결과를 출력하기 위한 버퍼라이터
    public static StringTokenizer st; // 문자열을 토큰화하기 위한 StringTokenizer
    public static StringBuilder sb;   // 문자열 결과를 저장할 StringBuilder

    public static void solution() {
        int now;

        lb: while (true) { // 레이블을 사용한 무한 루프
            for (int i = 1; i <= 5; i++) { // 1부터 5까지의 값을 빼서 큐에 추가
                now = q.poll(); // 큐의 맨 앞에서 값을 꺼내옴

                now = now - i > 0 ? now - i : 0; // 현재 값에서 i를 뺀 결과가 0보다 작으면 0으로 설정
                q.add(now); // 계산된 값을 큐에 추가

                if (now == 0) { // 현재 값이 0(0 이하가 되면서 0으로 세팅됨)인 경우 종료
                    break lb; // flag 사용 없이 레이블 활용 탈출
                }
            }
        }

        for (int i = 0; i < N; i++) { // 큐의 모든 값을 StringBuilder에 추가
            sb.append(q.poll()).append(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));   // 입력을 받기 위한 버퍼리더
        bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 결과를 출력하기 위한 버퍼라이터
        sb = new StringBuilder(); // 문자열 결과를 저장할 StringBuilder 초기화

        for (int t = 1; t <= testCase; t++) {
            br.readLine(); // input dummy

            q.clear(); // 큐 초기화
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                q.add(Integer.parseInt(st.nextToken())); // 큐 입력
            }

            sb.append("#").append(t).append(" "); // 테스트케이스 번호 저장

            solution(); // 암호 해독 메서드 호출 -> 솔루션 내에서 결과 값 저장
            sb.append("\n"); // 줄 바꿈 추가

            bw.write(sb.toString()); // 결과값 출력
            sb.setLength(0); // StringBuilder 초기화
        }

        bw.flush(); // 출력 버퍼 비우기
        bw.close(); // 출력 버퍼 닫기
    }
}
