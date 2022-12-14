package day01;

import java.util.Scanner;

public class MainDay01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String number = scan.next();
		char [] numberArr = number.toCharArray();
		
		int sum = 0;
		for(int i = 0; i < numberArr.length; i++) {
			sum += numberArr[i] - '0';
		}
		
		System.out.println(sum);
	}

}
