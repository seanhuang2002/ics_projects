package com.codename1.demos.signin.Signin;

import java.util.ArrayList;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;

public class CreateStudent extends Form{
	private Form mainForm;
	String gradeLevel="";
	ArrayList<Student> studentArray;
	public CreateStudent(Form mainForm, ArrayList<Student> studentArray)
	{
		this.studentArray=studentArray;
		this.mainForm=mainForm;
		setTitle("Creating Student Profile");
		setLayout(new BorderLayout());
		Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		final TextField fieldName = new TextField();
		fieldName.setHint("First Name");

		final TextField fieldLastName = new TextField();
		fieldLastName.setHint("Surname");

		Picker p = new Picker();
		p.setStrings("Pre Kindergarten","Junior Kindergarten","Senior Kingergarten","Grade 1","Grade 2",
				"Grade 3","Grade 4", "Grade 5","Grade 6","Grade 7","Grade 8/Level I","Grade 9/Level II",
				"Grade 10/Level III","Grade 11/Level IV","Grade 12/Level V");
		p.setSelectedString("Choose Grade Year");
		p.addActionListener(e -> {
			if(!p.getSelectedString().equals("Choose Grade Year")||!p.getSelectedString().equals(""))
			{
				gradeLevel=p.getSelectedString();
			}
		});

		final TextField fieldEmail = new TextField();
		fieldEmail.setHint("Email Address");
		fieldEmail.setConstraint(TextField.EMAILADDR);
		
		center.add(fieldName);
		center.add(fieldLastName);
		center.add(p);
		center.add(fieldEmail);

		final Button submit = new Button("Submit");
		submit.addActionListener((ActionListener)(ActionEvent e)->{
			if(!fieldName.getText().equals("")&&!fieldLastName.getText().equals("")&&!fieldEmail.getText().equals("")&&!gradeLevel.equals(""))
			{
				Student student = new Student(fieldName.getText()+fieldLastName.getText(),gradeLevel,fieldEmail.getText());
				studentArray.add(student);
				Dialog d = new Dialog("Success!");
				String l = "Student successfully added!";
				Label body = new Label(l);
				body.setUIID("DialogBody");
				Button close = new Button("OK");
				close.addActionListener((ActionListener)(ActionEvent evt) -> {
					d.dispose();
					mainForm.showBack();
				});
				d.setLayout(new BorderLayout());
				d.add(BorderLayout.CENTER, body);
				d.add(BorderLayout.SOUTH, close);
				d.show();
			}
			else 
			{
				Dialog d= new Dialog("Error!");
				String l = "Please fill all fields";
				Label body = new Label(l);
				body.setUIID("DialogBody");
				Button close = new Button ("OK");
				close.addActionListener((ActionListener)(ActionEvent evt)->{
					d.dispose();
				});
				d.setLayout(new BorderLayout());
				d.add(BorderLayout.CENTER, body);
				d.add(BorderLayout.SOUTH, close);
				d.show();
			}
		});
		final Button back = new Button("Back");
		back.addActionListener((ActionListener)(ActionEvent e)->{
			mainForm.showBack();
		});
		Container bottom = FlowLayout.encloseCenter(back,submit);
		this.addComponent(BorderLayout.SOUTH, bottom);
		this.addComponent(BorderLayout.CENTER, center);

	}

}
