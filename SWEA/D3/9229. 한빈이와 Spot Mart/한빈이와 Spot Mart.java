import java.io.*;
import java.util.*;

public class Solution {

    public static int N, M; // 과자 봉지의 수와 최대 무게
    public static int[] ws; // 과자 봉지의 무게 배열

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // 입력을 받기 위한 버퍼리더
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 결과를 출력하기 위한 버퍼라이터
    public static StringTokenizer st; // 문자열을 토큰화하기 위한 StringTokenizer

    public static int solution() {
        int l = 0; // 왼쪽 포인터
        int r = N - 1; // 오른쪽 포인터

        int ans = -1; // 결과값 초기화
        int now; // 현재 과자 봉지의 무게 합

        while (l < r) {
            now = ws[l] + ws[r];  // 현재 과자 봉지의 무게 합 계산
            if (now <= M) {       // 만약 무게 합이 최대 무게 이하이면
                ans = Math.max(ans, now); // 결과값을 갱신
            }

            if (now > M) {        // 만약 무게 합이 최대 무게를 초과하면,
                r--;              // 오른쪽 포인터를 한 칸 앞으로 이동하여 무게를 줄임
            } else if (now < M) { // 만약 무게 합이 최대 무게보다 작으면,
                l++;              // 왼쪽 포인터를 한 칸 뒤로 이동하여 무게를 늘림
            } else {              // 무게 합이 최대 무게와 같으면,
                break;            // 종료
            }
        }

        return ans; // 결과 반환
    }

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

        for (int t = 1; t <= tc; t++) { // 각 테스트 케이스에 대해
            st = new StringTokenizer(br.readLine()); // 라인 입력
            N = Integer.parseInt(st.nextToken()); // 과자 봉지의 수
            M = Integer.parseInt(st.nextToken()); // 최대 무게
            ws = new int[N]; // 과자 봉지의 무게 배열 초기화

            st = new StringTokenizer(br.readLine()); // 입력 받음
            for (int i = 0; i < N; i++) { // 각 과자 봉지의 무게에 대해
                ws[i] = Integer.parseInt(st.nextToken()); // 과자 봉지의 무게를 배열에 저장
            }

            Arrays.sort(ws); // 과자 봉지의 무게를 오름차순으로 정렬

            bw.write(String.format("#%d %d\n", t, solution())); // 결과 출력
        }

        bw.flush(); // 출력 버퍼 비우기
        bw.close(); // 출력 버퍼 닫기
    }
}
