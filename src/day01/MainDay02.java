package day01;

import java.util.Arrays;
import java.util.Scanner;

public class MainDay02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int score[] = new int[n];
		for(int i = 0; i < score.length; i++) {
			score[i] = scan.nextInt();
		}
		
		Arrays.sort(score);
		int max = score[n-1];
		
		int sum = 0;
		for(int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		
		double average = (double)sum / max * 100 / n;
		System.out.println(average);
	}

}
