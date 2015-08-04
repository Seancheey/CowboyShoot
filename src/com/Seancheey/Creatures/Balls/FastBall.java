package com.Seancheey.Creatures.Balls;

import com.Seancheey.EntityAttributes.TypeGetter;

public class FastBall extends Ball {
	public double v=50;
	public FastBall() {
		setType("fastBall");
		setImage("resource/Ball/Spider.png");
		reset();
	}

	public void makeMove(){
		v+=0.03*timer.getDelay();
		double angle=Math.atan2(TypeGetter.getPlayer(0).getCenterPosition().y-getCenterPosition().y,
				TypeGetter.getPlayer(0).getCenterPosition().x-getCenterPosition().x);
		
		setVx(v*Math.cos(angle));
		setVy(v*Math.sin(angle));
		px+=getVx()/1000*timer.getDelay();
		py+=getVy()/1000*timer.getDelay();
		refreshRotation();
	}
	
	public void reset() {
		HP=6+r.nextInt(4);
		refreshRotation();
		resetSize();
		v=50;
		if(r.nextInt(2)==1){
			if(r.nextInt(2)==1)
				py=2;
			else
				py=540-getSize();
			px=(2*r.nextDouble()-1)*(585-getSize());
		}else{
			if(r.nextInt(2)==1)
				px=2;
			else
				px=880-getSize();
			py=(2*r.nextDouble()-1)*(550-getSize());
		}
	}
}
