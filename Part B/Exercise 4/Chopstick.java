public class Chopstick {
	private int ID;
	private boolean free;

	Chopstick(int ID) {
		this.ID = ID;
		this.free = true;
	}
	
	synchronized void take() {
		while (!free) {
			try{
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		free = false;
	}
	
	synchronized void release() {
		free = true;
		notify();
	}
	    
	public int getID() {
	    return(ID);
	}
}
