package ch.fhnw.oop2.tasky.part5.ui.screen;


import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class TaskUi extends GridPane {
	private long id;
	private double TASK_TITEL_HIGHT  = 50;
	private double TASK_DESCRIPTION_HIGHT  = 100 -TASK_TITEL_HIGHT;
	private String color;
	Label labelTitel;
	Label labelDesc;
	
	public TaskUi(long id) {
		this.id = id;
		initializeControls(null);
		layoutControls();
		
	}

	private void initializeControls(String labelText) {
		labelTitel = new Label("Test");
		labelDesc = new Label("Desc");
		setColor(color);
		
	}
	
	private void layoutControls() {
		ConstraintHelper.setRowPercentConstraint(this, TASK_TITEL_HIGHT);
		ConstraintHelper.setRowPercentConstraint(this, TASK_DESCRIPTION_HIGHT);
		add(labelTitel,0,0);
		add(labelDesc,0,1);
		setPrefSize(Double.MAX_VALUE,Double.MAX_VALUE);
		setColor("#9b59b6");  // temp
	}
	
	
	
	
	public void setColor(String color) {
		setStyle("-fx-background-color: " +color + ";");
		
	}


	
}
