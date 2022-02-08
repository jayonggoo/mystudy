import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
class Axis {
	int y, x;
	
	Axis(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class Wheel {
    private static final int MAX_ALPHA_COUNT = 26;
	public static void main(String[] args) throws IOException {
        ArrayList<StringBuilder> strs = new ArrayList<>();
        String userdata;
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String temp;
            temp = br.readLine();
            strs.add(new StringBuilder(temp));
        }
        userdata = br.readLine();
        br.close();
        
        int sum = getTotalPrice(strs, userdata);
        System.out.println("$" + sum);
    }
	private static int getTotalPrice(ArrayList<StringBuilder> strs, String userdata) {
		int conCnt = 0;
        int[] ffirst = {0, 0, 0, 0, 0};
        int[] chance = {0, 0, 0, 0, 0};
        int sum = 0;
        ArrayList<Axis> pass;
        
        for (int i = 0; i < MAX_ALPHA_COUNT; i++) {    		
        	
        	pass = getJundap(strs, userdata.charAt(i));
        	setUsedChar(strs, pass);
            
        	conCnt = getCountinueCount(pass.size(), conCnt);
            
            sum += get2000Dollar(pass, chance);
            sum += get1000Dollar(pass, ffirst, chance);
            sum = getSingleDollar(conCnt, sum, pass.size());
            
            initChance(chance, pass.size());
        }
		return sum;
	}
	private static ArrayList<Axis> getJundap(ArrayList<StringBuilder> strs, char targetCh) {
		ArrayList<Axis> result = new ArrayList<Axis>();
		
		for (int y = 0; y < strs.size(); y++) {
		    for (int x = 0; x < strs.get(y).length(); x++) {
		        if (strs.get(y).charAt(x) != targetCh) continue;
		        
		        result.add(new Axis(y, x));
		    }
		}
		return result;
	}
	private static void initChance(int[] chance, int passCnt) {
		if (passCnt == 0) {
		    for (int t = 0; t < 5; t++) chance[t] = 0;
		}
	}
	private static int getSingleDollar(int conCnt, int sum, int passCnt) {
		sum += (conCnt * 100) * passCnt;
		return sum;
	}
	private static int getCountinueCount(int passCnt, int conCnt) {
		if (passCnt > 0) return conCnt + 1;
		return 0;
	}
	private static void setUsedChar(ArrayList<StringBuilder> strs, ArrayList<Axis> pass) {
		
		for (Axis ax : pass) {
	        strs.get(ax.y).setCharAt(ax.x, '_');	
		}
	}
	private static int get1000Dollar(ArrayList<Axis> pass, int[] ffirst, int[] chance) {
		
		int result = 0;
		for (Axis ax : pass) {
            if (ffirst[ax.y] == 0 && ax.x == 0) {
                result += 1000;
                chance[ax.y] = 1;
            }
            ffirst[ax.y] = 1;		
		}
		return result;
	}
	private static int get2000Dollar(ArrayList<Axis> pass, int[] chance) {
		int result = 0;
		for (Axis ax : pass) {
			int line = ax.y;
			if (chance[line] == 0) continue;			
			result += 2000;
		}
		
		for (int i = 0; i<5; i++) chance[i] = 0;
		return result;
	}
}