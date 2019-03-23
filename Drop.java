/*
 * 
 * @Bobur Murtozaev
 */
public class Drop {
	
	// Message sent from producer
    // to consumer.
    private double number;
    private double[] array = new double[1];
    private int i = 0;
    // True if consumer should wait
    // for producer to send message,
    // false if producer should wait for
    // consumer to retrieve message.
    private boolean empty = true;

    public synchronized double[] take() {
        // Wait until message is
        // available.
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        // Toggle status.
        empty = true;
        // Notify producer that
        // status has changed.
        notifyAll();
        return this.array;
    }

    public synchronized void put(double numbmber) {
        // Wait until message has
        // been retrieved.
        while (!empty) {
            try { 
                wait();
            } catch (InterruptedException e) {}
        }
        // Toggle status.
        empty = false;
        
        if(this.array[this.array.length-1]!=0) {
        	double[] ar = new double[this.array.length+1];
        	for(int j=0; j<this.array.length; j++) {
        		ar[j] = this.array[j];
        	}
        	
        	this.array = ar;
        }
        
        
       
        this.array[i] = numbmber;
        i++;
        
      
        
       
        
        
        // Store message.
        //this.array = array;
        // Notify consumer that status
        // has changed.
        notifyAll();
    }

}
