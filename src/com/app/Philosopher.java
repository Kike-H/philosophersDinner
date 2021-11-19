package com.app;

/**
* Philosopher
*/
public class Philosopher extends Thread {
	private int id;
	private Chopstick chopstick;
	private boolean flag;

	public Philosopher(int id, Chopstick chopstick) {
		this.id = id;
		this.chopstick = chopstick;
		this.flag = true;
		System.out.println("Philosopher "+(this.id+1)+" arrived 🧐");
	}

	@Override
	public void run() {
			while(flag) {
				System.out.println("\t"+"Philosopher "+(this.id+1)+" is thinking about a problem 🤔");
				int left  = this.id;
				int right = (this.id+1)%chopstick.getNumberChopstick();

				if(right > left) {
					int aux = left;
					left = right;
					right = aux;
				}

				this.chopstick.getChopStick(left);
				System.out.println("\t\t"+"Philosopher "+(this.id+1)+" take chopstick on the left 🥢 ");

				this.chopstick.getChopStick(right);
				System.out.println("\t\t"+"Philosopher"+(this.id+1)+" take chopstick on the right 🥢 ");

				System.out.println("\t\t\t"+"The philosopher "+(this.id+1)+" is eating 🤤");

				try {
					Thread.sleep((int)Math.random()*5000+2000);
				} 
				catch( InterruptedException e ){e.printStackTrace();}

				this.chopstick.leaveChopStick(left);
				System.out.println("\t\t"+"Philosopher "+(this.id+1)+" go down the left chopstick 🥢");

				this.chopstick.leaveChopStick(right);
				System.out.println("\t\t"+"Philosopher "+(this.id+1)+" go down the right chopstick 🥢");
			}
	}

	public void stopThread() {
		this.flag = false;
	}
}
