package ch.fhnw.oop2.tasky.part5.ui.screen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.sun.java.accessibility.util.GUIInitializedListener;

import ch.fhnw.oop2.tasky.part1.model.State;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Diese Klasse gruppiert die Lanes auf dem Bildschirm. Sie sorgt dafür, dass die Lanes
 * resizable sind.
 *
 */
final class LaneGroup extends GridPane {
	
	private static double ONE_HUNDRED_PERCENT = 100.0;
	private static double BOTTOM_HEIGHT_PERCENT = 10.0;
	private static double LANE_HEIGHT_PERCENT = ONE_HUNDRED_PERCENT - BOTTOM_HEIGHT_PERCENT;
	private int column;
	private Button create;
	private Button refresh;
	

	/**
	 * Erzeugt eine neue LaneGroup.
	 * 
	 * @param stateLines Die Lanes in der Gruppe
	 */
	LaneGroup(ApplicationUI gui, List<Lane> stateLines) {
		initializeControls(gui);
		layoutControls(stateLines);
	}
	
	private void initializeControls(ApplicationUI gui) {
		create = new Button("New");
		refresh = new Button("Refresh");
		create.setOnAction(event -> { gui.createNewTask();
										});
		}
	
	private void layoutControls(List<Lane> lanes) {
		setMargin(this, new Insets(10));
		ConstraintHelper.setRowPercentConstraint(this, LANE_HEIGHT_PERCENT);
		column = 0;
		lanes.stream()
			.forEach(lane -> {
				ConstraintHelper.setColumnPercentConstraint(this, ONE_HUNDRED_PERCENT / lanes.size());		
				add(lane,column++,0);
				});
		
		ConstraintHelper.setRowPercentConstraint(this, BOTTOM_HEIGHT_PERCENT);
		HBox buttons = new HBox();
		buttons.setSpacing(10);
		buttons.getChildren().addAll(create, refresh);
		add(buttons, 0, 1, lanes.size(), 1);
		GridPane.setMargin(buttons, new Insets(7, 0, 5, 10));
	}
	
}
