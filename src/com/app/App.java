package com.app; 

class App {
	public static void main(String[] args) throws InterruptedException {
		//Make the shared chopsticks 
		Chopstick chopstick = new Chopstick();

		//Make the table with the five philosophers
		Philosopher[] table = new Philosopher[] {
			new Philosopher(0, chopstick),
			new Philosopher(1, chopstick),
			new Philosopher(2, chopstick),
			new Philosopher(3, chopstick),
			new Philosopher(4, chopstick)
		};


		//Initial all the philosophers
		for (Philosopher philosopher : table) {
			philosopher.start();
		}

		//Wait for 25 seconds 
		Thread.sleep(25000);

		//End all the procesors
		for (Philosopher philosopher : table) {
			philosopher.stopThread();
		}

	} 
}
