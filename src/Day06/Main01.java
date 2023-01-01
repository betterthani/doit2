package Day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main01 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		mData a[] = new mData[n];
		for(int i = 0; i < n; i++) {
			a[i] = new mData(Integer.parseInt(br.readLine()), i);
		}
		
		Arrays.sort(a);
		int max = 0;
		for(int i = 0; i < n; i++) {
			if(max < a[i].index - i) { // 정렬 전 index - 정렬 후 index 계산의 최댓값 저장하기
				max = a[i].index-i;
			}
			
		}
		System.out.println(max + 1);
		

	}
	

}
class mData implements Comparable<mData>{
	int value;
	int index;
	
	public mData(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}
	
	@Override
	public int compareTo(mData o) {
		return this.value - o.value; // 오름차순
	}
}
