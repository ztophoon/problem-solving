import java.io.*;

public class Main {

    public static int N;

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringBuilder sb;

    public static int [][] cheatSHIT = {
            {2, 3, 5, 7},
            {23, 29, 31, 37, 53, 59, 71, 73, 79},
            {233, 239, 293, 311, 313, 317, 373, 379, 593, 599, 719, 733, 739, 797},
            {2333, 2339, 2393, 2399, 2939, 3119, 3137, 3733, 3739, 3793, 3797, 5939, 7193, 7331, 7333, 7393},
            {23333, 23339, 23399, 23993, 29399, 31193, 31379, 37337, 37339, 37397, 59393, 59399, 71933, 73331, 73939},
            {233993, 239933, 293999, 373379, 373393, 593933, 593993, 719333, 739391, 739393, 739397, 739399},
            {2339933, 2399333, 2939999, 3733799, 5939333, 7393913, 7393931, 7393933},
            {23399339, 29399999, 37337999, 59393339, 73939133},
    };

    public static void solution() throws Exception {
        for(int n : cheatSHIT[N-1]){
            bw.write(sb.append(n).append("\n").toString());
            sb.setLength(0);
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        solution();

        bw.flush();
        bw.close();
    }
}
