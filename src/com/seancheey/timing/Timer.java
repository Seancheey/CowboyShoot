package com.seancheey.timing;

public class Timer {
	private int delay = 20;
	private RefreshAction action;
	private Thread repeatAction;
	private boolean willContinue, stopped;

	public Timer(int delay, RefreshAction action) {
		this.delay = delay;
		this.action = action;
		repeatAction = new RepeatAction();
		willContinue = true;
		stopped = false;
	}

	private class RepeatAction extends Thread {
		public void run() {
			do {
				while (!stopped) {
					action.refreshAction();
					try {
						sleep(delay);
					} catch (InterruptedException e) {
						// e.printStackTrace();
					}
				}
				try {
					Thread.sleep(15);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} while (willContinue);
		}
	}

	public void start() {
		repeatAction.start();
	}

	public void stop() {
		stopped = true;
	}

	public void restart() {
		stopped = false;
	}

	public void kill() {
		stop();
		willContinue = false;
		action = null;
	}

	public int getDelay() {
		return delay;
	}
}
