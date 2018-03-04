package br.pro.hashi.ensino.desagil.tequilada;

public class Tequilada {
	public static void main(String[] args){
		Engine engine = new Engine();
		
		engine.board = new Board();
		engine.board.loadFromFile("board.txt");
		
		engine.cpuPlayer = new Player();
		engine.humanPlayer = new Player();
		
		for(int i = 0;i < 19; i++){
			if(engine.board.isWall[1][i]){
				System.out.println("eh");
			}
			else{
				System.out.println("N eh");
			}
		}
	}

}
