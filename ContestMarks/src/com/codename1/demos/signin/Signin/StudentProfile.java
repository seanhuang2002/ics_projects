package com.codename1.demos.signin.Signin;

import java.util.ArrayList;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

public class StudentProfile extends Form{

	private Form mainForm;
	private Form oldForm;
	private Student selectedStudent;
	private Entry selectedEntry;
	ArrayList<Entry> marksData;
	public StudentProfile(Form mainForm, Student selectedStudent, ArrayList<Entry> marksData, Form oldForm)
	{
		this.mainForm=mainForm;
		this.selectedStudent=selectedStudent;
		this.marksData=marksData;
		this.oldForm=oldForm;
		setLayout(new BorderLayout());
		setTitle(selectedStudent.getName());
		Container north = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		
		Label name = new Label("Name: "+selectedStudent.getName());
		Label grade = new Label("Grade: "+selectedStudent.getGradeYear());
		Label email = new Label("Email: "+selectedStudent.getEmail());
		north.addComponent(name);
		north.addComponent(grade);
		north.addComponent(email);
		this.addComponent(BorderLayout.NORTH,north);
		
		for(int i = 0; i<marksData.size();i++)
		{
			selectedEntry = marksData.get(i);
			if(marksData.get(i).getStudent()==selectedStudent)
			{
				Button but = new Button(marksData.get(i).getContestName());
				but.addActionListener((ActionListener)(ActionEvent e)->{
					Dialog d = new Dialog(selectedEntry.getContestName());
					String l = "Mark: " + selectedEntry.getMark();
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
				});
			}
		}
		
		final Button back = new Button("Back");
		final Button close = new Button("Close");
		back.addActionListener((ActionListener)(ActionEvent e)->{
			oldForm.showBack();
		});
		back.addActionListener((ActionListener)(ActionEvent e)->{
			mainForm.showBack();
		});
		Container bottom = FlowLayout.encloseCenter(back,close);
		this.addComponent(BorderLayout.SOUTH, bottom);
		this.addComponent(BorderLayout.CENTER, center);		
		
	}
}
