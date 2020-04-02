package ch.fhnw.oop2.tasky.part5.ui.screen;

import java.util.List;
import ch.fhnw.oop2.tasky.part1.model.Task;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Diese Klasse implementiert den visuellen Behälter für eine Task-Sorte (Todo, Doing, ...).
 * 
 */
final class Lane extends GridPane {

	private final static int MAX_TASKS_PER_LANE = 5;
	private Label label;
	private List<Task> tasks;
	private int row = 0;
	private ApplicationUI gui;
	
	/**
	 * Erzeugt eine neue Lane.
	 * 
	 * @param labelText Der Labeltext für die Lane
	 * @param tasks Die Tasks in den Lane
	 * @param gui 
	 */
	Lane(String labelText, List<Task> tasks, ApplicationUI gui) {
		this.tasks = tasks;
		this.gui = gui;
		initializeControls(labelText);
		layoutControls();
	}
	
	private void initializeControls(String labelText) {
		label = new Label(labelText);
		
	}
	
	private void layoutControls() {
		// Nur eine Spalte für diese Lane.
		ConstraintHelper.setColumnPercentConstraint(this, 100);

		// Für das Label.
		add(label, 0, 0);
		ConstraintHelper.setRowPercentConstraint(this, 5);
		GridPane.setMargin(label, new Insets(0, 0, 0, 3));
		
		// Padding für die Lane.
		setPadding(new Insets(5));
		
//		updateLane();
		row = 1;
		
		// Zeichne Spalte neu
		updateLane();

	}

	private void updateLane() {
		row = 1;
		tasks.stream()
		.forEach(task -> {
			TaskUi newTask = new TaskUi(task,gui);
			ConstraintHelper.setRowPercentConstraint(this, 95.0 / MAX_TASKS_PER_LANE);
			add(newTask, 0, row++);
			GridPane.setMargin(newTask, new Insets(3));
		});

		
		
	}		
	
}