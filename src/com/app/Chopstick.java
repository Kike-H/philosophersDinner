package com.app;

import java.util.concurrent.Semaphore;

/**
* Chopstick
*/
public class Chopstick {
	//Make a array with five semaphores for each chopsticks
	private Semaphore[] chopsticks = new Semaphore[] {
		new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1)
	};

	//Mark the semaphore's chopstick as busy
	public void getChopStick(int num_chopstick) {
		try {
			this.chopsticks[num_chopstick].acquire();
		}
		catch ( InterruptedException e ) {e.printStackTrace();}
	}

	//Mark the semaphore's chopstick as free
	public void leaveChopStick(int num_chopstick) {
		this.chopsticks[num_chopstick].release();
	}

	//Get the size of the array
	public int getNumberChopstick() {
		return this.chopsticks.length;
	}
}
