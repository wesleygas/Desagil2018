package br.pro.hashi.ensino.desagil.tequilada;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

// Estrutura básica de um componente Swing.
public class View extends JPanel {
	// Estrutura básica de um componente Swing.
	private static final long serialVersionUID = 1L;


	// Constante que define o tamanho de cada célula do tabuleiro.
	private static final int CELL_SIZE = 50;


	private Model model;
	private Image cpuPlayerImage;
	private Image humanPlayerImage;


	public View(Model model) {
		this.model = model;

		cpuPlayerImage = loadImage("cpuPlayer");
		humanPlayerImage = loadImage("humanPlayer");

		// Define o tamanho da componente, em pixels.
		setPreferredSize(new Dimension(model.getBoard().getNumCols() * CELL_SIZE, model.getBoard().getNumRows() * CELL_SIZE));
	}


	// Método para carregar uma imagem a partir de um nome de arquivo.
	// Não é necessário entender todos os detalhes nesse momento.
	private Image loadImage(String filename) {
		URL url = getClass().getResource("/" + filename + ".png");
		ImageIcon icon = new ImageIcon(url);
		return icon.getImage();
	}


	// Método para desenhar uma imagem a partir da posição de um jogador.
	// Não é necessário entender todos os detalhes nesse momento.
	private void drawImage(Graphics g, Image image, Player player) {
		g.drawImage(image, player.getCol() * CELL_SIZE, player.getRow() * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);
	}


	// M�todo para desenhar a interface gr�fica do jogo. A ideia �
	// que o parâmetro g pode ser usado como o pincel de desenho.
	@Override
	public void paintComponent(Graphics g) {
		// Define a cor do pincel como branco.
		int numCols = model.getBoard().getNumCols();
		int numRows = model.getBoard().getNumRows();
		// Pinta um ret�ngulo do tamanho da tela inteira.
		g.setColor(Color.WHITE);		
		g.fillRect(0, 0, numCols* CELL_SIZE, numRows* CELL_SIZE);
		g.setColor(Color.BLACK);
		for(int x=0; x < numCols;x++){
			for(int y=0; y < numRows;y++){
				if(model.getBoard().isWall(y, x)){
					g.fillRect(x*CELL_SIZE, y*CELL_SIZE, CELL_SIZE, CELL_SIZE);
				}
			}
		}
		// Pinta as imagens dos jogadores.
		drawImage(g, cpuPlayerImage, model.getCpuPlayer());
		drawImage(g, humanPlayerImage, model.getHumanPlayer());

		// Evita bugs visuais em alguns sistemas operacionais.
		getToolkit().sync();
    }
}
