import java.io.*;
import java.util.*;

public class Main {

    public static int N, Size, R, C;
    public static int answer;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static boolean isIn(int sr, int sc, int er, int ec){
        if(sr <= R && R <= er && sc <= C && C <= ec) return true;
        return false;
    }

    public static int getOffset(int sr, int sc){
        if(sr == R && sc == C) {
            return 0;
        } else if(sr == R && sc != C) {
            return 1;
        } else if(sr != R && sc == C) {
            return 2;
        } else {
            return 3;
        }
    }

    public static void solution(int sr, int sc, int er, int ec) throws IOException {
        if(er - sr == 1 && ec - sc == 1){
            answer += getOffset(sr, sc);
            return;
        }

        int midR = (int) Math.floor((double) (sr + er) / 2);
        int midC = (int) Math.floor((double) (sc + ec) / 2);

        if(isIn(sr, sc, midR, midC)) {
            solution(sr, sc, midR, midC);
        } else if(isIn(sr, midC + 1, midR, ec)){
            answer += (int) Math.pow((midR - sr) + 1, 2) * 1;
            solution(sr, midC + 1, midR, ec);
        } else if(isIn(midR + 1, sc, er, midC)){
            answer += (int) Math.pow((er - (midR + 1)) + 1, 2) * 2;
            solution(midR + 1, sc, er, midC);
        } else if(isIn(midR + 1, midC + 1, er, ec)){
            answer += (int) Math.pow((er - (midR + 1)) + 1, 2) * 3;
            solution(midR + 1, midC + 1, er, ec);
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Size = (int) Math.pow(2, N);
        solution(0, 0, Size - 1, Size - 1);

        bw.write(answer + "");
        bw.close();
    }
}
