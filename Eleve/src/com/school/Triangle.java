package com.school;

public class Triangle extends Polygone 
{
	private double base = 8, hauteur = 2;
	public double calculerSurface()
	{
		return base*hauteur*0.5;
	}
}
