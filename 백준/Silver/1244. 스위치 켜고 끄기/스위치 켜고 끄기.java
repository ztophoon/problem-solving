import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int numSwitches;
    public static int numStudents;
    public static int [] switches;

    public static int gender;
    public static int target;

    public static void solution() {
        if (gender == 1){

            for(int i = target; i < numSwitches; i++){
                if(i % target == 0){
                    switches[i] ^= 1;
                }
            }
        } else if (gender == 2){

            int offset = 0;
            while(1 <= target - offset && target + offset < numSwitches){

                if(switches[target + offset] != switches[target - offset]){
                    break;
                }
                offset++;
            }
            offset--;

            for(int i = target - offset; i <= target + offset; i++){;
                if(i > numSwitches - 1){
                    break;
                }
                switches[i] ^= 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        numSwitches = Integer.parseInt(br.readLine()) + 1;
        switches = new int [numSwitches];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < numSwitches; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }

        numStudents = Integer.parseInt(br.readLine());
        for(int i = 0; i < numStudents; i++){
            st = new StringTokenizer(br.readLine());
            gender = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            solution();
        }

        for(int i = 1; i < numSwitches; i++){
            bw.write(switches[i] + " ");
            if(i % 20 == 0){
                bw.write("\n");
            }
        }
        bw.newLine();

        bw.flush();
    }
}
