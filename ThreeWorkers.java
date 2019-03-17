import java.util.Scanner;
//Done by Bobur Murtozaev
public class ThreeWorkers extends Thread {

	static double average;
	static double minimum;
	static double maximum;
	static double number;
	static double[] array;
	static int i;

	public static void main(String[] args) {

		array = new double[5];
		i = 0;

		ThreeWorkers thue = new ThreeWorkers();

		thue.start();

		Scanner scan = new Scanner(System.in);

		do {

			do {

				System.out.print("Please enter a positive number or '0' to stop: ");

				try {

					thue.sleep(500);

				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}

				while (!scan.hasNextDouble()) {

					System.out.print("That's not a number! Try again: ");

					scan.next();
				}

				number = scan.nextDouble();

				while (number < 0) {

					System.out.print("Don't enter negative number! Try again: ");

					while (!scan.hasNextDouble()) {

						System.out.print("That's not a number! Try again: ");

						scan.next();
					}

					number = scan.nextDouble();
				}

				if (number != 0) {

					System.out.println("OK. Got " + number);

					run(number);

					try {
						thue.sleep(500);

					} catch (InterruptedException e) {

						e.printStackTrace();
					}

				} else {

					break;
				}

			} while (number > 0);

			System.out.println("You have stopped the input!");

		} while (number != 0);

	}

	public static void run(double number2) {

		try {

			System.out.println("Accepted this: " + number2);

			array[i] = number2;
			
			i++;
			
				if(array[array.length-1]!=0) {
				
					System.out.println("Array is full!");
					
					System.out.println("Extending the array size!");
					
					
					
					double[] arr = new double[array.length*2];
					
					for(int u=0; u<array.length; u++) {
						
						arr[u] = array[u];
					}
					
					array = arr;
					
					System.out.print("New array: ");
					
					for(int e=0; e<array.length; e++) {
						
						System.out.print(array[e]);
					}
					
					System.out.println();
			}
				
				

		} catch (Exception e) {

			System.out.println("Error");
		}

		for (int j = 0; j < array.length; j++) {

			System.out.println("array: " + array[j]);
			
		}
		
		

	}

}
