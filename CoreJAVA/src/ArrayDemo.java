import java.util.Scanner;

public class ArrayDemo {
	public static void main(String[] args) {
		int i[]= {1,2,3,4,5};
		for(int index=0;index<=4;index++) {
			System.out.println(i[index]);
		}
		int size;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size of array : ");
		size  = sc.nextInt();
		int arr[] = new int[size];
		for(int index=0;index<arr.length;index++) {
			System.out.print("enter value at arr["+index+"] : ");
			arr[index] = sc.nextInt();
		}
		for(int index=0;index<arr.length;index++) {
			System.out.println(arr[index]);
		}
		int sum=0;
		for(int index=0;index<arr.length;index++) {
			sum = sum + arr[index];
		}
		System.out.println("sum = "+sum);
		int num,counter=0;
		System.out.println("enter element to search in array : ");
		num = sc.nextInt();
		for(int index=0;index<arr.length;index++) {
			if(arr[index]==num) {
				counter++;
			}
		}
		if(counter==1) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
}
