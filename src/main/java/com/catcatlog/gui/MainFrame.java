package com.catcatlog.gui;

import com.catcatlog.model.Matrix;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
	public MainFrame() {
		SwingUtilities.invokeLater(() -> {
			setTitle("5 x 5 Matrix");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Matrix matrix = new Matrix(5);
			matrix.random();
			add(new MatrixDisplay(matrix));
			pack();
		});
	}

	@Override
	public Dimension getPreferredSize()
	{
		return super.getPreferredSize();
	}
}
