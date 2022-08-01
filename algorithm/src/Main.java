import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = 1;
		int int_value = 666;
		String str_value = "666";
		
		while(num != N) {
			int_value += 1000;
			str_value = Integer.toString(int_value);
			
			int index = str_value.indexOf("666") + 2;
			if(index == str_value.length() - 1) {
				num++;
			} else {
				int str_length = str_value.length();
				str_value = str_value.substring(0, index + 1);
				for(int i = index + 1; i < str_length; i++) {
					str_value += "0";
				}
				int_value = Integer.parseInt(str_value);
				num++;
				while(str_value.indexOf("666") + 2 == index) {
					if(num >= N) {
						System.out.println(int_value);
						return;
					}
					int_value++;
					str_value = Integer.toString(int_value);
					num++;
				}
				str_value = str_value.substring(0, str_value.length() - 3);
				str_value += "666";
				int_value = Integer.parseInt(str_value);
				num--;
			}
		}
		System.out.println(int_value);
	}
}
