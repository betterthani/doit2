package Day06;

import java.io.IOException;
import java.util.Scanner;

public class Main02 {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		int a[] = new int[str.length()];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(str.substring(i,i+1));
		}
		
		for(int i = 0; i < a.length; i++) {
			int max = i;
			for(int j = i+1; j < a.length; j++) {
				if(a[j] > a[max]) {
					max = j;
				}
			}
			
			if(a[i] < a[max]) {
				int temp = a[i];
				a[i] = a[max];
				a[max] = temp;
			}
		}
		
		for(int i = 0; i < str.length(); i++) {
			System.out.print(a[i]);
		}
	}

}
