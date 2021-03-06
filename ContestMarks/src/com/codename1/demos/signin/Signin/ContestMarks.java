package com.codename1.demos.signin.Signin;


import static com.codename1.ui.CN.addNetworkErrorListener;
import static com.codename1.ui.CN.updateNetworkThreadCount;

import java.util.ArrayList;

import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class ContestMarks {

	private Form mainForm;
	private Resources theme;
	ArrayList<Student> studentArray = new ArrayList<Student>();
	ArrayList<Entry> marksData = new ArrayList<Entry>();

	public void init(Object context) {
		// use two network threads instead of one
		updateNetworkThreadCount(2);

		theme = UIManager.initFirstTheme("/theme");

		// Enable Toolbar on all Forms by default
		Toolbar.setGlobalToolbar(true);

		// Pro only feature, uncomment if you have a pro subscription
		Log.bindCrashProtection(true);

		addNetworkErrorListener(err -> {
			// prevent the event from propagating
			err.consume();
			if(err.getError() != null) {
				Log.e(err.getError());
			}
			Log.sendLogAsync();
			Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
		});        
	}

	public void start() {
		mainForm = new Form("Welcome!");
		mainForm.setLayout(new BorderLayout());
		Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		center.setUIID("ContainerWithPadding");

		Image logo = theme.getImage("mLogo.png");
		Label l = new Label(logo);
		Container flow = new Container(new FlowLayout(Component.CENTER));
		flow.addComponent(l);
		center.addComponent(flow);

		Label welcomeText = new Label("Welcome to the Test Results App!");
		final Button createStudent = new Button("Create Student Profile");
		createStudent.addActionListener((ActionListener)(ActionEvent evt)->{
			CreateStudent createStudentForm = new CreateStudent(mainForm, studentArray);
			createStudentForm.show();
		});
		final Button addEntry = new Button("Add Marks to Profile");
		addEntry.addActionListener((ActionListener)(ActionEvent e)->{
			if(studentArray.size()!=0)
			{
				AddMarks addMarks = new AddMarks(mainForm,studentArray,marksData);
				addMarks.show();
			}
			else
			{
				Dialog d = new Dialog("Error!");
				String as = "Please add a student first";
				Label body = new Label(as);
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
		});
		final Button viewEntry = new Button("View Marks by Student");
		viewEntry.addActionListener((ActionListener)(ActionEvent e)->{
			if(studentArray.size()!=0)
			{
				ViewMarks addMarks = new ViewMarks(mainForm,studentArray);
				addMarks.show();
			}
			else
			{
				Dialog d = new Dialog("Error!");
				String as = "Please add a student first";
				Label body = new Label(as);
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
		});
		final Button allEntry = new Button("View All Marks");
		allEntry.addActionListener((ActionListener)(ActionEvent evt)->{

		});
		final Button about = new Button("About this App");
		about.addActionListener((ActionListener)(ActionEvent evt)->{
			About a = new About(mainForm);
			a.show();
		});

		center.addComponent(welcomeText);
		center.addComponent(createStudent);
		center.addComponent(addEntry);
		center.addComponent(viewEntry);
		center.addComponent(allEntry);
		center.addComponent(about);

		Toolbar tb = mainForm.getToolbar();
		Image icon = theme.getImage("icon.png");
		Container topBar = BorderLayout.east(new Label(icon));
		topBar.add(BorderLayout.SOUTH, new Label("Cool App Tagline...", "SidemenuTagline"));
		topBar.setUIID("SideCommand");
		tb.addComponentToSideMenu(topBar);

		tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {
			mainForm.show();
		});
		tb.addMaterialCommandToSideMenu("Create Student", FontImage.MATERIAL_CREATE, e -> {
			CreateStudent createStudentForm = new CreateStudent(mainForm, studentArray);
			createStudentForm.show();
		});
		tb.addMaterialCommandToSideMenu("Add Marks", FontImage.MATERIAL_ADD, e -> {
			if(studentArray.size()!=0)
			{
				AddMarks addMarks = new AddMarks(mainForm,studentArray,marksData);
				addMarks.show();
			}
			else
			{
				Dialog d = new Dialog("Error!");
				String as = "Please add a student first";
				Label body = new Label(as);
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
		});
		tb.addMaterialCommandToSideMenu("View Marks", FontImage.MATERIAL_DESCRIPTION, e -> {
			if(studentArray.size()!=0)
			{
				ViewMarks addMarks = new ViewMarks(mainForm,studentArray);
				addMarks.show();
			}
			else
			{
				Dialog d = new Dialog("Error!");
				String as = "Please add a student first";
				Label body = new Label(as);
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
		});
		tb.addMaterialCommandToSideMenu("View All Marks", FontImage.MATERIAL_LIST, e -> {});
		tb.addMaterialCommandToSideMenu("View All Students", FontImage.MATERIAL_VIEW_AGENDA, e -> {});
		tb.addMaterialCommandToSideMenu("About", FontImage.MATERIAL_INFO, e -> {
			About a = new About(mainForm);
			a.show();
		});


		mainForm.addComponent(BorderLayout.CENTER, center);
		mainForm.show();
	}

	public void stop() {
	}

	public void destroy() {
	}

}
