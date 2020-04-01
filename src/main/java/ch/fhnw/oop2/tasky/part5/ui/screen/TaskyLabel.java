package ch.fhnw.oop2.tasky.part5.ui.screen;


import javafx.scene.control.Label;

public class TaskyLabel extends Label {
	private long id;
	private String color;
	
	public TaskyLabel(long id,String color) {
		this.id = id;
		this.color = color;
		initializeControls(null);
		layoutControls();
		
	}

	
	
	
	private void initializeControls(String labelText) {
		label = new Label(labelText);
	}
	
	private void layoutControls() {
		
	}
	
	
	
	
	public boolean setColor(String color) {
		setStyle("-fx-background-color: " +color + ";");
	


	final Label label = new Label();
	label.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
	label.setStyle("-fx-background-color: " +color + ";");
	return label;

	}
}
