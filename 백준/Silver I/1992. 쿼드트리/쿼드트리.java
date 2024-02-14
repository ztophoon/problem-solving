import java.io.*;

public class Main {

    public static int N; // 영상의 크기
    public static int [][] arr; // 영상 입력 배열

    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int isFilled(int sr, int sc, int er, int ec){ // 주어진 영역이 모두 하나의 값으로 채워져있는지 확인
        int fill = arr[sr][sc]; // 첫 번째 값 확인
        for(int r = sr; r <= er; r++){
            for(int c = sc; c <= ec; c++){
                if(fill != arr[r][c]) { // 첫 번째 값과 불일치하는지 비교
                    return -1; // 불일치하는 경우 탈출
                }
            }
        }
        return fill; // 모두 일치하는 경우 해당 값 반환
    }

    public static void solution(int sr, int sc, int er, int ec) {
        int fill = isFilled(sr, sc, er, ec); // 반복 전 영역이 같은 값으로 채워져있는지 확인

        if(fill != -1){
            sb.append(fill); // 같은 값으로 채워져있다면 그 값을 출력 버퍼에 추가
            return;
        }

        int midR = (int) Math.floor((double) (sr + er) / 2); // 영역의 행 좌표를 절반으로 나누고 버림한 좌표 값
        int midC = (int) Math.floor((double) (sc + ec) / 2); // 영역의 열 좌표를 절반으로 나누고 버림한 좌표 값

        sb.append("("); // 새 쿼드트리 시작 괄호
        solution(sr, sc, midR, midC);         // 왼쪽 위 재귀 탐색
        solution(sr, midC + 1, midR, ec);     // 오른쪽 위 재귀 탐색
        solution(midR + 1, sc, er, midC);     // 왼쪽 아래 재귀 탐색
        solution(midR + 1, midC + 1, er, ec); // 오른쪽 아래 재귀 탐색
        sb.append(")"); // 새 쿼드트리 종료 괄호
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 영상 크기 입력

        arr = new int [N][N];
        for(int i = 0; i < N; i++){
            char [] inp = br.readLine().toCharArray(); // 영상 값 입력 후 배열로 변환
            for(int j = 0; j < N; j++){
                arr[i][j] = inp[j] - '0'; // 배열 순회하면서 정수 형 값으로 입력
            }
        }

        solution(0, 0, N - 1, N - 1); // 전체 영역에 대한 탐색 시작

        bw.write(sb.toString()); // 결과를 버퍼에 추가
        bw.close(); // 버퍼 출력
    }
}
