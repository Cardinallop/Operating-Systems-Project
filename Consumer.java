/*
 * @Bobur Murtozaev
 * 
 */


import java.util.Random;

public class Consumer implements Runnable {

	 private Drop drop;
	 
	 private double[] numba;
	 private double sum = 0;
	 

	    public Consumer(Drop drop) {
	        this.drop = drop;
	    }

	    public void run() {
	        Random random = new Random();
	        for (numba = drop.take();
	             numba.length!=0;
	             this.numba = drop.take()) {
	            
	            System.out.println();
	            
	           for(int g=0; g<this.numba.length; g++) {
	        	   sum = sum + this.numba[g];
	        	   System.out.println("g: " + this.numba[g]);
	           }
	           
	           System.out.println("length: " + this.numba.length);
	           
	           System.out.println("sum: " + sum);
	           
	           
	           
	           System.out.println("The average: "+(sum/this.numba.length));
	            
	            
	            
	            try {
	                Thread.sleep(random.nextInt(5000));
	            } catch (InterruptedException e) {}
	        }
	    }

}
