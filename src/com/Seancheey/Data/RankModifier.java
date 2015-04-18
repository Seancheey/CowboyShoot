package com.Seancheey.Data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.Seancheey.GUI.MainPanel;
public class RankModifier {
	private RandomAccessFile r;
	public static int[] scoreList=new int[10];
	public static String[] nameList=new String[10];
	
	public RankModifier() {
		try {
			r=new RandomAccessFile("dat/rank.dat", "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			for(int ba=0;ba<10;ba++){
				nameList[ba]=r.readUTF();
				scoreList[ba]=r.readInt();
			}
			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addNewRank(String newName,int newScore){
		int No = 0;
		for(;No<10;No++){
			if(newScore>=scoreList[No])
				break;
		}
		if(No!=10){
			for(int ba=9;ba>No;ba--){
				nameList[ba]=nameList[ba-1];
				scoreList[ba]=scoreList[ba-1];
			}
			nameList[No]=newName;
			scoreList[No]=newScore;
			writeRank();
		}
	}
	
	private void writeRank(){
		try {
			r=new RandomAccessFile("dat/rank.dat", "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try{
			for(int ba=0;ba<10;ba++){
				r.writeUTF(nameList[ba]);
				r.writeInt(scoreList[ba]);
			}
		r.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		MainPanel.rank.refreshRank();
	}
}
