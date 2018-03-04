package br.pro.hashi.ensino.desagil.tequilada;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Board {
	boolean[][] isWall;
	//A classe board tem uma variável que é uma matriz bidimensional booleana 
	
	void loadFromFile(String path){
		//Como vamos lidar com algo externo, temos que nos prevenir de erros
		try{
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
			String[] dimensions = line.split(" ");
			int rows = Integer.parseInt(dimensions[0]);
			int cols = Integer.parseInt(dimensions[1]);
			isWall = new boolean[rows][cols];
			
			for(int i =0; i< rows;i++){
				line = reader.readLine();
				for(int j = 0; j<cols;j++){
					boolean cache;
					if(line.charAt(j) == '#'){
						cache = true;
					}
					else{
						cache = false;
					}
					
					isWall[i][j] = cache;
				}
			}
		reader.close();
		
		}
		catch(FileNotFoundException exception) {
			System.out.println(exception);
		}
		catch(IOException exception) {
			System.out.println(exception);
		}
		
	}
}
