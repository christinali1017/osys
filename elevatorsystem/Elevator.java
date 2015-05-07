package elevatorsystem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The interface for Elevator. It defines the behavior shared by all Elevators. 
 * @author wish
 */
public abstract class Elevator {
	private int currentFloor;
	private Queue<Integer> destFloors;
	
	public Elevator(int curFloor) {
		this.currentFloor = curFloor;
		this.destFloors = new LinkedList<Integer>();
	}
	
	public int getCurrentFloor() {
		return this.currentFloor;
	}
	
	public int nextDest() {
		return this.destFloors.peek();
	}
	
	
	
}
