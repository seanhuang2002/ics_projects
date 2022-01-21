package com.school;

public class Mere 
{
	protected void colourYeux()
	{
		System.out.println("Mes yeux sont blues");
	}
	public void chanterMaVoix()
	{
		System.out.println("lalalalalalalalalalalalalalalalalalalalalo");
	}
	//surcharge de la méthode Overlead 
	public void chanterMaVoix(String chanson)
	{
		String chant=chanson;
		System.out.println("Je chante "+chant);
	}

}
