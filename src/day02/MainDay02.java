package day02;

import java.util.Scanner;

public class MainDay02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int startIndex = 1;
		int endIndex = 1;
		int count = 1;
		int sum = 1;
		
		while(endIndex != n) {
			if(sum == n) {
				count++;
				endIndex++;
				sum += endIndex;
			} else if (sum > n) {
				sum -= startIndex;
				startIndex++;
			} else {
				endIndex++;
				sum += endIndex;
			}
		}
		System.out.println(count);
		
	}
}
