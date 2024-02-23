import java.io.*;
import java.util.*;

public class Main {

    public static int N, X, taste;
    public static ArrayList<Integer> tasteDiff;

    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void solution() throws IOException {
        int price = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int menu5000 = Integer.parseInt(st.nextToken());
            int menu1000 = Integer.parseInt(st.nextToken());

            if(menu5000 > menu1000) {
                taste += menu5000;
                price += 5000;

                tasteDiff.add(menu5000 - menu1000);
            } else {
                taste += menu1000;
                price += 1000;
            }
        }

        Collections.sort(tasteDiff);

        int idx = 0;
        int liSize = tasteDiff.size();
        while(price > X){
            taste -= tasteDiff.get(idx++);
            price -= 4000;

            if(idx == liSize){
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        tasteDiff = new ArrayList<>();

        solution();

        bw.write(taste + "");
        bw.close();
    }
}
