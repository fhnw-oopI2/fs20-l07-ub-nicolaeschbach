package ch.fhnw.oop2.tasky.part1.model;



public enum State {
	Todo("#2ecc71"), 
	Doing("#3498db"), 
	Done("#e74c3c"), 
	Review("#9b59b6");
	
	private String color;
	
	State(String color){
		this.color = color;
	}

	public String getColor() {
		return color;
	}
}
