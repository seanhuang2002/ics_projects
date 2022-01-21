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

public class AddMarks extends Form{
	private Form mainForm;
	ArrayList<Student> studentArray;
	ArrayList<Entry> marksData;
	String selectedStudentName;
	Student selectedStudent = new Student(null,null,null);
	public AddMarks (Form mainForm, ArrayList<Student> studentArray, ArrayList<Entry> marksData)
	{
		this.studentArray=studentArray;
		this.marksData=marksData;
		this.mainForm=mainForm;
		setTitle("Adding Marks to Student");
		setLayout(new BorderLayout());
		Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		
		Picker p = new Picker();
		String[] studentNames = new String [studentArray.size()];
		for(int i=0;i<studentArray.size();i++)
		{
			studentNames[i]=studentArray.get(i).getName();
		}
		p.setStrings(studentNames);
		p.setSelectedString("Choose Student");
		p.addActionListener(e->{
			if(!p.getSelectedString().equals("Choose Student")||!p.getSelectedString().equals(""))
			{
				selectedStudentName=p.getSelectedString();
			}
		});
		for(int i=0;i<studentArray.size();i++)
		{
			if(studentArray.get(i).getName().equals(selectedStudentName))
			{
				selectedStudent=studentArray.get(i);
			}
		}
		
		final TextField fieldContest = new TextField();
		fieldContest.setHint("Contest Name");
		
		final TextField fieldMark = new TextField();
		fieldMark.setHint("Mark Obtained");
		
		final Button submit = new Button("Submit");
		submit.addActionListener((ActionListener)(ActionEvent e)->{
			if(!fieldContest.getText().equals("")&&!fieldMark.getText().equals("")&&selectedStudent!=null)
			{
				Entry a = new Entry(selectedStudent,fieldContest.getText(),Integer.parseInt(fieldMark.getText()));
				marksData.add(a);
				Dialog d = new Dialog("Success!");
				String l = "Marks successfully added!";
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
		center.add(p);
		center.add(fieldMark);
		center.add(fieldContest);
		Container bottom = FlowLayout.encloseCenter(back,submit);
		this.addComponent(BorderLayout.SOUTH, bottom);
		this.addComponent(BorderLayout.CENTER, center);
	}
}
