package com.app;

import java.util.concurrent.Semaphore;

/**
* Chopstick
*/
public class Chopstick {
	private Semaphore[] chopsticks = new Semaphore[] {
		new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1)
	};

	public void getChopStick(int num_chopstick) {
		try {
			this.chopsticks[num_chopstick].acquire();
		}
		catch ( InterruptedException e ) {e.printStackTrace();}
	}

	public void leaveChopStick(int num_chopstick) {
		this.chopsticks[num_chopstick].release();
	}

	public int getNumberChopstick() {
		return this.chopsticks.length;
	}
}
