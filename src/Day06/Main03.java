package Day06;

import java.util.Arrays;
import java.util.Scanner;

public class Main03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[]= new int[n];
		for(int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		
		int sum = 0;
		int result = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
			result += sum;
		}
		System.out.println(result);
	}

}
