package com.Seancheey.Data.KeyHandling;

public abstract class ReactableKey implements KeyReaction{
	private int keyCode;
	
	public ReactableKey(int keyCode){
		this.keyCode=keyCode;
	}
	
	public int getKeyCode(){
		return keyCode;
	}
	
	public boolean matchKey(int inputKey){
		if(inputKey==keyCode)
			return true;
		else
			return false;
	}
}
