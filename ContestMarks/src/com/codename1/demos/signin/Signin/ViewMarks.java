package com.codename1.demos.signin.Signin;

import java.util.ArrayList;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

public class ViewMarks extends Form {
	private Form mainForm;
	ArrayList<Student> studentArray;
	public ViewMarks(Form mainForm, ArrayList<Student> studentArray)
	{
		this.studentArray = studentArray;
		this.mainForm = mainForm;
		setTitle("View Student Profiles");
		setLayout(new BorderLayout());
		Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		for(int i = 0; i<studentArray.size();i++)
		{
			Button button = new Button(studentArray.get(i).getName());
			button.addActionListener((ActionListener)(ActionEvent e)->{
				//TODO add a new form that opens and shows the Info of the student and shows their associated marks
			});
		}
		final Button back = new Button("Back");
		back.addActionListener((ActionListener)(ActionEvent e)->{
			mainForm.showBack();
		});
		Container bottom = FlowLayout.encloseCenter(back);
		this.addComponent(BorderLayout.SOUTH, bottom);
		this.addComponent(BorderLayout.CENTER, center);
	}
}
