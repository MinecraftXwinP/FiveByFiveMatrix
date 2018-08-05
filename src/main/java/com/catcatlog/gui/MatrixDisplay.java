package com.catcatlog.gui;

import com.catcatlog.model.Matrix;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MatrixDisplay extends JPanel
{
	public static final int CELL_SIZE = 100;
	public static final int OFFSET = 60;
	public static final int NUMBER_SIZE = 40;
	private Matrix matrix;

	public MatrixDisplay(Matrix matrix) {
		this.matrix = matrix;
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D drawer = (Graphics2D)g.create();
		drawer.setColor(Color.BLUE);
		int matrixSize = matrix.getSize();
		Font font = new Font("TimesRoman",Font.BOLD,NUMBER_SIZE);
		drawer.setFont(font);
		for (int x = 0; x < matrixSize; x++) {
			for(int y = 0; y < matrixSize; y++){
				String text = String.valueOf(matrix.get(x,y));
				Rectangle2D textBound = font.getStringBounds(text,drawer.getFontRenderContext());

				Rectangle rect = new Rectangle(
						OFFSET + x * CELL_SIZE,
						OFFSET + y * CELL_SIZE,
						CELL_SIZE,
						CELL_SIZE);
				drawer.draw(rect);
				drawer.drawString(
						String.valueOf(matrix.get(x,y)),
						((int)Math.ceil(OFFSET + x * CELL_SIZE + ((float)CELL_SIZE) / 2 - textBound.getWidth() / 2)),
						((int)Math.ceil(OFFSET + y * CELL_SIZE + ((float)CELL_SIZE) / 2 + textBound.getHeight() / 2))
				);
			}
		}

		drawer.dispose();
	}

	@Override
	public Dimension getPreferredSize()
	{
		int panelSize = matrix.getSize() * CELL_SIZE + OFFSET * 2;
		return new Dimension(panelSize,panelSize);
	}
}
