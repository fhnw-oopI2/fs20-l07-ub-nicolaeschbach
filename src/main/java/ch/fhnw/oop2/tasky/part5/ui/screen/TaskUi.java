package ch.fhnw.oop2.tasky.part5.ui.screen;


import ch.fhnw.oop2.tasky.part1.model.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class TaskUi extends GridPane {
	private Task task;
	private ApplicationUI gui;
	private Label labelTitel;
	private Label labelDesc;
	private double TASK_TITEL_HIGHT  = 30;
	private double TASK_DESCRIPTION_HIGHT  = 100 -TASK_TITEL_HIGHT;

	
	public TaskUi(Task task, ApplicationUI gui) {
		this.task = task;
		initializeControls();
		layoutControls();
	}

	private void initializeControls() {
		labelTitel = new Label(task.data.title);
		labelDesc = new Label(task.data.desc);
	//	addEventHandler(onMou, eventHandler);
//		setOnMouseClicked(x-> System.out.println(this.task.id));
		setOnMouseClicked(x-> ApplicationUI.getSelectetTask().set(this.task.id));
	}
	
	private void layoutControls() {
		ConstraintHelper.setRowPercentConstraint(this, TASK_TITEL_HIGHT);
		ConstraintHelper.setRowPercentConstraint(this, TASK_DESCRIPTION_HIGHT);
		add(labelTitel,0,0);
		add(labelDesc,0,1);
		labelDesc.setAlignment(Pos.TOP_LEFT);
		labelDesc.setPrefHeight(Double.MAX_VALUE);
		setPrefSize(Double.MAX_VALUE,Double.MAX_VALUE);
		setStyle("-fx-background-color: " + task.data.state.getColor() + ";");
		setPadding(new Insets(3));
	}
	
	public void updateTask(String color) {
		setStyle("-fx-background-color: " + task.data.state.getColor() + ";");
		labelTitel.setText(task.data.title);
		labelDesc.setText(task.data.desc);
		
	}
}
