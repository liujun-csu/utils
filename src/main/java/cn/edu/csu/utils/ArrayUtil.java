package cn.edu.csu.utils;

import java.util.Arrays;

public class ArrayUtil {
	/**
	 * 数组选择排序
	 * @param arr	数组
	 */
	public static void selectSort(int[] arr){
		int len = arr.length;
		for (int i = 0; i < len-1; i++) {
			for (int j = i+1; j < len; j++) {
				if (arr[j] < arr[i]) {
					swap(arr, i, j);
				}
			}
		}
	}
	/**
	 * 将数组指定区间排序，包含头，不包含尾
	 * @param arr	数组
	 * @param start	起点
	 * @param end	终点
	 */
	public static void selectSort(int[] arr, int start, int end){
		for (int i = start; i < end-1; i++) {
			for (int j = i+1; j < end; j++) {
				if (arr[j] < arr[i]) {
					swap(arr, i, j);
				}
			}
		}
	}
	/**
	 * 冒泡排序
	 * @param arr	数组
	 */
	public static void bubbleSort(int[] arr){
		int len = arr.length;
		for (int i = 0; i < len-1; i++) {
			for (int j = 0; j < len-1; j++) {
				if (arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
	}
	/**
	 * 交换数组两元素位置
	 * @param arr	数组
	 * @param i	交换位置1
	 * @param j	交换位置2
	 */
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	} 
	public static void main(String[] args) {
		int[] arr = {15,12,8,26,35,18,27,55,3};
		System.out.println(Arrays.toString(arr));
//		bubbleSort(arr);
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}
