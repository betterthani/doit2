package Day06;

import java.util.Scanner;

public class Prac {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];
		int s[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		
		for(int i = 1; i < n; i++) {
			int insertPoint = i;
			int insertValue = a[i];
			
			for(int j = i-1; j >= 0; j--) {
				if(a[j] < a[i]) {
					insertPoint = j+1; // i=나 , 나보다 더 작은 수 발견하면 j+1
					break;
				}
				
				if(j == 0) { // 제일 작은애가 0번째
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
		for(int i = 0; i < n; i++) {
			sum += s[i];
		}
		System.out.println(sum);
		
	}
}

