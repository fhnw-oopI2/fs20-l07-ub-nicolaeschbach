package ch.fhnw.oop2.tasky.part5.ui.screen;

import java.lang.Thread.State;
import java.util.List;

import ch.fhnw.oop2.tasky.part1.model.Task;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * Diese Klasse implementiert den visuellen Behälter für eine Task-Sorte (Todo, Doing, ...).
 * 
 */
final class Lane extends GridPane {

	private final static int MAX_TASKS_PER_LANE = 5;
	private double TASK_TITEL_HIGHT  = 50;
	private double TASK_DESCRIPTION_HIGHT  = 100 -TASK_TITEL_HIGHT;
	private Label label;
	private List<Task> tasks;
	private int row = 0;

	
	/**
	 * Erzeugt eine neue Lane.
	 * 
	 * @param labelText Der Labeltext für die Lane
	 * @param tasks Die Tasks in den Lane
	 */
	Lane(String labelText, List<Task> tasks) {
		this.tasks = tasks;

		
		initializeControls(labelText);
		layoutControls();
	}
	
	private void initializeControls(String labelText) {
		label = new Label(labelText);
		
		tasks.stream()
			.filter(x-> x == null);
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
		
//		tasks.stream()
//			.forEach(task -> {
//				ConstraintHelper.setRowPercentConstraint(this, 95.0 / MAX_TASKS_PER_LANE);
//				add(task, 0, row++);
//				GridPane.setMargin(task, new Insets(3));
//			});
	}
	
	private void updateLane() {
		row = 0;
		tasks.stream()
		.forEach(task -> {
			TaskUi newTask = new TaskUi(task.id);
			add(newTask,0,row++);
			ConstraintHelper.setRowPercentConstraint(newTask, TASK_TITEL_HIGHT);
			ConstraintHelper.setRowPercentConstraint(newTask, TASK_DESCRIPTION_HIGHT);

//			ConstraintHelper.setRowPercentConstraint(this, 95.0 / MAX_TASKS_PER_LANE);
//			add(task, 0, row++);
//			GridPane.setMargin(task, new Insets(3));
		});
		
		
	}		
	
	
}
