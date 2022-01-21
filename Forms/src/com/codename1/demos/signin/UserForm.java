package com.codename1.demos.signin;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

public class UserForm extends Form{
	private String name;
	private String password;
	private String email;
	private String phone;
	
	public UserForm(String name, String password, String email, String phone ) {
		this.name=name;
		this.password=password;
		this.email=email;
		this.phone=phone;
		setTitle("Bienvenu ! "+name);
		setLayout(new BorderLayout());
		Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		//7:20
		Label name1 = new Label(name);
		Label password1 = new Label(password);
		Label email1 = new Label(email);
		Label phone1 = new Label(phone);
		
		center.add(name1);
		center.add(password1);
		center.add(email1);
		center.add(phone1);
		this.addComponent(BorderLayout.CENTER, center);
	}

}
