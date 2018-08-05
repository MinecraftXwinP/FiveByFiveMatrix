package com.catcatlog.model;


import java.util.Random;

public class Matrix
{
	private int[][] numbers;
	public Matrix() {
		this(5);
		random();
	}
	public Matrix(int size) {
		numbers = new int[size][size];
	}

	public void random() {
		Random rand = new Random();
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers.length; j++) {
				numbers[i][j] = rand.nextInt(4) + 1;
			}
		}
	}

	public int getSize() {
		return numbers[0].length;
	}

	public int get(int x,int y) {
		return numbers[x][y];
	}
}
