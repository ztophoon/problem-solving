import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int ans;

    static int [][] grid;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void fill(int x, int y){
        for(int i = x; i < x + 10; i++){
            for(int j = y; j < y + 10; j++){
                if(grid[i][j] == 1){
                    continue;
                }

                grid[i][j] = 1;
                ans++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        grid = new int[101][101];

        int x, y;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            fill(x, y);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }

}
