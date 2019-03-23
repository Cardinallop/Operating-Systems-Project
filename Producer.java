/*
 * @Bobur Murtozaev
 * 
 */


import java.util.Random;
import java.util.Scanner;

public class Producer implements Runnable {

	private Drop drop;

	public Producer(Drop drop) {
		this.drop = drop;
	}

	public void run() {
		Scanner scan = new Scanner(System.in);
		double nummmber;
		do {
			System.out.print("Enter your number: ");
			nummmber = scan.nextDouble();

			Random random = new Random();

			drop.put(nummmber);

			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
			}
		} while (nummmber != 0);
		drop.put(0);
	}

}
