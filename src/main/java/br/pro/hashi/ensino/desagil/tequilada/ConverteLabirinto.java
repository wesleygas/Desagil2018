package br.pro.hashi.ensino.desagil.tequilada;

import java.io.BufferedReader;
//import java.io.File;
import java.io.FileReader;
//import java.io.IOException;
import java.lang.StringBuilder;

public class ConverteLabirinto {
	public static void main(String[] args){
		System.out.println("Inicio");
		
		BufferedReader reader = new BufferedReader(new FileReader("labirinto.txt"));
		
		try{
			StringBuilder sb = new StringBuilder("Java");
			String line = reader.readLine();
			
			while(line != null){
				sb.append(line);
				sb.append(System.lineSeparator());
				line = reader.readLine();
			}
			String everything = sb.toString();
		}
		
		finally{
			reader.close();
		}
		System.out.println(everything);
		
	}
}
