public class Chopstick {
	private int ID;
	private boolean free;

	Chopstick(int ID) {
    
		this.ID = ID;
		this.free = true;
	}
	
	synchronized boolean Take(int waitTime) {
    
        long startTime = System.currentTimeMillis();
        while (!free) {
            try {
                wait(waitTime);
              
                if (System.currentTimeMillis() - startTime >= waitTime) {
                    return false;
                }
            } catch (InterruptedException e) {
                System.out.print(e);
            }
        }
        free = false;
        return true;
    }
	
	synchronized void release() {
		free = true;
		notify();
	}
	    
	public int getID() {
	    return(ID);
	}
}
