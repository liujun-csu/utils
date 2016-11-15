package cn.edu.csu.arithmetic;

import java.util.Arrays;
import java.util.Random;

public class LotteryRandomGenerate {
	public static void main(String[] args) {
		doubleBall();
		superLotto();
	}
	/**
	 * 随机生成双色球
	 */
	public  static void doubleBall(){
		Random random = new Random();
		int[] result = new int[7];
		boolean[] picked = new boolean[33];
		for (int i = 0; i < 6; i++) {
			int t;
			do {
				t = random.nextInt(33);
			} while (picked[t]);
			result[i] = t+1;
			picked[t] = true;
		}
		result[6] = random.nextInt(16)+1;
		sort(result, 0, 6);
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(picked));
	}
	/**
	 * 随机生成大乐透
	 */
	public static void superLotto(){
		Random random = new Random();
		int[] result = new int[7];
		boolean[] picked = new boolean[35];
		for (int i = 0; i < 5; i++) {
			int t;
			do {
				t = random.nextInt(35);
			} while (picked[t]);
			result[i] = t+1;
			picked[t] = true;
		}
		sort(result, 0, 5);
		System.out.println(Arrays.toString(picked));
		picked = new boolean[12];
		for (int i = 5; i < 7; i++) {
			int t;
			do {
				t = random.nextInt(12);
			} while (picked[t]);
			result[i] = t+1;
			picked[t] = true;
		}
		sort(result, 5, 7);
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(picked));
	}
	/**
	 * 将数组指定区间排序，包含头，不包含尾
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void sort(int[] arr, int start, int end){
		for (int i = start; i < end-1; i++) {
			for (int j = i+1; j < end; j++) {
				if (arr[j] < arr[i]) {
					swap(arr, i, j);
				}
			}
		}
	}
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
