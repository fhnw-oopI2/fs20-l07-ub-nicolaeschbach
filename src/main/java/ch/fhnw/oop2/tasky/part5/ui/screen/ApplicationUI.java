package ch.fhnw.oop2.tasky.part5.ui.screen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.fhnw.oop2.tasky.part1.model.Repository;
import ch.fhnw.oop2.tasky.part1.model.State;
import ch.fhnw.oop2.tasky.part1.model.Task;
import ch.fhnw.oop2.tasky.part1.model.TaskData;
import ch.fhnw.oop2.tasky.part1.model.impl.InMemoryMapRepository;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * Diese Klasse teilt den Bildschirm in die zwei Hauptgebiete auf:
 * (a) Lane Group
 * (b) Detail-Ansicht einer ausgewählten Task.
 *
 */
public final class ApplicationUI extends GridPane {
	
	private static final int TASKLANE_PERCENT = 60;
	private static final int DETAILS_PERCENT = 40;
	
	private Lane todo;
	private Lane doing;
	private Lane done;
	private Lane review;
	private InMemoryMapRepository repository; //
	private LongProperty taskSelected; //
	private List<Lane> stateLines;
	/**
	 * Erzeugt einen neuen MainScreen.
	 */
	public ApplicationUI() {
		repository = new InMemoryMapRepository(); //
		taskSelected = new SimpleLongProperty(); //
		

		repository.create(new TaskData("Task1", "erster Task fuer test" , LocalDate.now(), State.Todo));
		repository.create(new TaskData("Task2", "zweiter Task fuer test" , LocalDate.now(), State.Doing));
		repository.create(new TaskData("Task3", "dritter Task fuer test" , LocalDate.now(), State.Doing));
		repository.create(new TaskData("Task3", "dritter Task fuer test" , LocalDate.now(), State.Doing));
		repository.create(new TaskData("Task1", "erster Task fuer test" , LocalDate.now(), State.Todo));
		repository.create(new TaskData("Task2", "zweiter Task fuer test" , LocalDate.now(), State.Done));
		repository.create(new TaskData("Task2", "zweiter Task fuer test" , LocalDate.now(), State.Done));
		repository.create(new TaskData("Task3", "dritter Task fuer test" , LocalDate.now(), State.Review));
		repository.create(new TaskData("Task3", "dritter Task fuer test" , LocalDate.now(), State.Doing));
		repository.create(new TaskData("Task2", "zweiter Task fuer test" , LocalDate.now(), State.Done));
		repository.create(new TaskData("Task2", "zweiter Task fuer test" , LocalDate.now(), State.Done));
		repository.create(new TaskData("Task3", "dritter Task fuer test" , LocalDate.now(), State.Review));
		repository.create(new TaskData("Task3", "dritter Task fuer test" , LocalDate.now(), State.Doing));
//		repository.create(new TaskData("Task3", "dritter Task fuer test" , LocalDate.now(), State.Review));
		
		initializeControls();
		layoutControls();
	}
	
	private void initializeControls() {
		stateLines = new ArrayList<Lane>();
		for (State state : State.values()) {
			stateLines.add(new Lane(state.name(), repository.read().stream().filter(x -> x.data.state == state).collect(Collectors.toList())));
		}
		setGridLinesVisible(true);
	}
	
	private void layoutControls() {
		ConstraintHelper.setRowPercentConstraint(this, 100); // Höhe soll generell voll ausgefüllt werden.		
		ConstraintHelper.setColumnPercentConstraint(this, TASKLANE_PERCENT);
		
		add(new LaneGroup(this, stateLines), 0, 0);
		
		ConstraintHelper.setColumnPercentConstraint(this, DETAILS_PERCENT);
		add(new Detail(), 1, 0);
		
	}
	
	private List<Region> createTasks(String color) {
		List<Region> tasks = new ArrayList<>();
		
		Stream.iterate(1, n -> n + 1)
			.limit((int)(1 + Math.random() * 4))
			.forEach(n -> tasks.add(Area.createRegion(color)));
		return tasks;
		
//		return null;
	}
	
	
	public Repository getRepository() {
		return repository;
	}
	
	public void displayTasks() {
		;
	}
	
	public void createNewTask() {
		repository.create(new TaskData(null, null, null, null));
		System.out.println("New Task created: "+ repository.read((repository.read().size()-1)));
	}

}
