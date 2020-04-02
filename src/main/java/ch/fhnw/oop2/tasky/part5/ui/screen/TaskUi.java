package ch.fhnw.oop2.tasky.part5.ui.screen;


import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class TaskUi extends GridPane {
	private long id;
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
		labelTitel = new Label("Desc");
		setColor(color);
		
	}
	
	private void layoutControls() {
		getChildren().add(0, labelTitel);
		getChildren().add(1, labelDesc);
		setPrefSize(Double.MAX_VALUE,Double.MAX_VALUE);
	}
	
	
	
	
	public void setColor(String color) {
		setStyle("-fx-background-color: " +color + ";");
		
	}


	
}
