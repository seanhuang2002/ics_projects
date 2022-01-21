package com.codename1.demos.signin.Signin;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

public class About extends Form{
	private Form mainForm;
	public About(Form mainForm)
	{
		this.mainForm=mainForm;
		setTitle("About this App");
		setLayout(new BorderLayout());
		Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		String s = "This app was created by Sean Huang for J.Zagabe's ICS4U "
				+ "Computer Science class at the Toronto "
				+ "French School in 2019 with Codename One";
		Label l = new Label(s);
		
		center.add(l);
		final Button back = new Button("Back");
		back.addActionListener((ActionListener)(ActionEvent e)->{
			mainForm.showBack();
		});
		Container bottom = FlowLayout.encloseCenter(back);
		this.addComponent(BorderLayout.SOUTH, bottom);
		this.addComponent(BorderLayout.CENTER, center);
	}

}
