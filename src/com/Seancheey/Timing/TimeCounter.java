package com.Seancheey.Timing;

public class TimeCounter {
	private int time=0;
	private Thread counter=new Thread(){
			public void run(){
				while(true){
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						
					}
					time++;
				}
			}
		};
	
	public TimeCounter(){
		counter.start();
		counter.interrupt();
	}
	
	public void start(){
		time=0;
		try {
			counter.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void stop(){
		counter.interrupt();
	}
	
	public void reset(){
		counter.interrupt();
		time=0;
	}
	public int getTime(){
		return time;
	}
	
}
