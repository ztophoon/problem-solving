import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int answer = Integer.MAX_VALUE;

    public static int [] nowChickens;
    public static ArrayList<int []> chickens = new ArrayList<>();
    public static ArrayList<int []> homes = new ArrayList<>();

    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void delivery(){
        int chickenDist = 0;

        for(int i = 0; i < homes.size(); i++){
            int [] h = homes.get(i);
            int hr = h[0];
            int hc = h[1];

            int minDist = Integer.MAX_VALUE;
            for(int j = 0; j < nowChickens.length; j++){
                if(nowChickens[j] != 1){
                    continue;
                }

                int [] c = chickens.get(j);
                int cr = c[0];
                int cc = c[1];

                minDist = Math.min(minDist, Math.abs(hr - cr) + Math.abs(hc - cc));
            }

            chickenDist += minDist;
        }

        answer = Math.min(answer, chickenDist);
    }

    public static void getChickens(int idx, int cnt){
        if(cnt == M){
            delivery();
            return;
        }

        for(int i = idx + 1; i < chickens.size(); i++){
            nowChickens[i] = 1;
            getChickens(i , cnt + 1);
            nowChickens[i] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [][] board = new int [N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = -Integer.parseInt(st.nextToken());

                if(board[i][j] == -1) {
                    homes.add(new int [] {i, j});
                } else if(board[i][j] == -2){
                    chickens.add(new int [] {i, j});
                }
            }
        }

        nowChickens = new int [chickens.size()];
        getChickens(-1, 0);

        bw.write(answer + "");
        bw.close();
    }
}
