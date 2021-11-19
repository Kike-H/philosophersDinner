package com.app; 

class App {
	public static void main(String[] args) throws InterruptedException {
		Chopstick chopstick = new Chopstick();

		Philosopher[] table = new Philosopher[] {
			new Philosopher(1, chopstick),
			new Philosopher(2, chopstick),
			new Philosopher(3, chopstick),
			new Philosopher(4, chopstick),
			new Philosopher(5, chopstick)
		};


		for (Philosopher philosopher : table) {
			philosopher.start();
		}

		Thread.sleep(3000);

		for (Philosopher philosopher : table) {
			philosopher.stopThread();
		}

	} 
}
