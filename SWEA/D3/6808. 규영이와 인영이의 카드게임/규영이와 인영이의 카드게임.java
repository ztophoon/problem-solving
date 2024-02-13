import java.io.*;
import java.util.*;

public class Solution {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringTokenizer st;

    public static int testCase;

    public static int win, lose; // 이긴 횟수와 진 횟수 변수 선언
    public static int[] cards, kCard, iCard, used; // 카드 배열, 규영이의 카드 배열, 인영이의 카드 배열, 사용 여부 배열 선언

    public static void solution(int depth, int kScore, int iScore) {
        if (depth == 9) { // 모든 카드를 뽑았을 때,
            if (kScore > iScore) { // 규영이 승리
                win++;
            } else if (kScore < iScore) { // 규영이 패배
                lose++;
            }
        } else {
            for (int i = 0; i < 9; i++) { // 9개의 카드 중에서
                if (used[i] == 1) { // 이미 사용한 카드이면,
                    continue; // 다음 카드로 넘어감
                }

                int kNewScore = kScore, iNewScore = iScore; // 새로운 규영이와 인영이의 점수 변수 초기화
                if (kCard[depth] > iCard[i]) { // 규영이의 카드가 인영이의 카드보다 클 때,
                    kNewScore += (kCard[depth] + iCard[i]); // 규영이의 점수에 카드의 합을 더함
                } else if (kCard[depth] < iCard[i]) { // 규영이의 카드가 인영이의 카드보다 작을 때,
                    iNewScore += (kCard[depth] + iCard[i]); // 인영이의 점수에 카드의 합을 더함
                }

                used[i] = 1; // 사용한 카드 표시
                solution(depth + 1, kNewScore, iNewScore); // 재귀를 통한 카드 탐색
                used[i] = 0; // 사용한 카드 표시 해제
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            win = 0;  // 이긴 횟수 초기화
            lose = 0; // 진 횟수 초기화

            cards = new int[19]; // 전체 카드 배열 초기화
            kCard = new int[9];  // 규영이의 카드 배열 초기화
            iCard = new int[9];  // 인영이의 카드 배열 초기화
            used = new int[9];   // 사용 여부 배열 초기화

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                kCard[i] = Integer.parseInt(st.nextToken()); // 규영이의 카드 입력 받기
                cards[kCard[i]] = 1; // 뽑힌 카드 표시
            }

            int idx = 0; // 인영이의 카드 배열 인덱스 초기화
            for (int i = 1; i <= 18; i++) {
                if (cards[i] == 0) {  // 뽑히지 않은 카드에 대해,
                    iCard[idx++] = i; // 인영이의 카드 배열에 추가
                }
            }

            solution(0, 0, 0);

            bw.write(String.format("#%d %d %d\n", t, win, lose));
        }

        bw.close();
    }
}
