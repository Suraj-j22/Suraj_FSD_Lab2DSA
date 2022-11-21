import java.util.Scanner;
class payMoney {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of transaction array :");
		int n = in.nextInt();
		System.out.println("Enter the values of array :");
		int transaction[] = new int[n];
		for (int i = 0; i < n; i++)
			transaction[i] = in.nextInt();
		System.out.println("Enter the total no of targets that needs to be achieved :");
		int targetAchNo = in.nextInt();
		while (targetAchNo-- != 0) {
			int flag = 0, target;
			System.out.println("Enter the value of target :");
			target = in.nextInt();
			int sum = 0;
			for (int i = 0; i < n; i++) { 
				sum = sum+transaction[i];
				if (sum >= target) {
					System.out.println("Target achieved after "+(i + 1) + " transactions ");
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println(" Given target is not achieved ");
			}
		}
		in.close();
	}
}
