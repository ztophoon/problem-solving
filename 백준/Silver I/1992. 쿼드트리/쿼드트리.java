import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int [][] arr;

    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int isFilled(int sr, int sc, int er, int ec){
        int fill = arr[sr][sc];
        for(int r = sr; r <= er; r++){
            for(int c = sc; c <= ec; c++){
                if(fill != arr[r][c]) {
                    return -1;
                }
            }
        }
        return fill;
    }

    public static void solution(int sr, int sc, int er, int ec) {
        int fill = isFilled(sr, sc, er, ec);

        if(fill != -1){
            sb.append(fill);
            return;
        }

        int midR = (int) Math.floor((double) (sr + er) / 2);
        int midC = (int) Math.floor((double) (sc + ec) / 2);

        sb.append("(");
        solution(sr, sc, midR, midC);
        solution(sr, midC + 1, midR, ec);
        solution(midR + 1, sc, er, midC);
        solution(midR + 1, midC + 1, er, ec);
        sb.append(")");
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int [N][N];
        for(int i = 0; i < N; i++){
            char [] inp = br.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                arr[i][j] = inp[j] - '0';
            }
        }

        solution(0, 0, N - 1, N - 1);

        bw.write(sb.toString());
        bw.close();
    }
}
