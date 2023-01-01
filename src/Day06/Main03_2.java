package Day06;

import java.util.Scanner;

public class Main03_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];
		int s[] = new int[n];
		for(int i = 0; i < a.length; i++) {
			a[i] = scan.nextInt();
		}
		
		for (int i = 1; i < n; i++) { // 삽입 정렬
			int insertPoint = i;
			int insertValue = a[i];
			for(int j = i-1; j >= 0; j--) {
				if(a[j] < a[i]) {
					insertPoint = j+1;
					break;
				}
				
				if(j == 0) {
					insertPoint = 0;
				}
			}
			
			for(int j = i; j > insertPoint; j--) {
				a[j] = a[j-1];
			}
			a[insertPoint] = insertValue;
		}
		
		s[0] = a[0];
		for(int i = 1; i < n; i++) {
			s[i] = s[i-1] + a[i];
		}
		
		int sum = 0;
		for(int i= 0; i < n; i++) {
			sum += s[i];
		}
		
		System.out.println(sum);
	}

}
