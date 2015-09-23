package elevatorsystem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The interface for Elevator. It defines the behavior shared by all Elevators. 
 * @author wish
 */
public abstract class AbstractElevator {
	private int currentFloor;
	private Queue<Integer> destFloors;
	
	public AbstractElevator(int curFloor) {
		this.currentFloor = curFloor;
		this.destFloors = new LinkedList<Integer>();
	}
	
	public int getCurrentFloor() {
		return this.currentFloor;
	}
	
	public int nextDest() {
		return this.destFloors.peek();
	}
	
	public void moveUp() {
		currentFloor++;
	}
	
	public void moveDown() {
		currentFloor--;
	}
	
	public void addDestination(Integer dest) {
		destFloors.add(dest);
	}
	
	public ElevatorDirection direction() {
		if (destFloors.size() > 0) {
			if (currentFloor < destFloors.peek()) {
				return ElevatorDirection.UP;
			} else if (currentFloor > destFloors.peek()) {
				return ElevatorDirection.DOWN;
			} else {
				return ElevatorDirection.HOLD;
			}
		} else {
			return ElevatorDirection.HOLD;
		}
	}
	
	public ElevatorStatus getStatus() {
		if (destFloors.size() > 0) {
			return ElevatorStatus.OCCUPIED;
		} else {
			return ElevatorStatus.IDLE;
		}
	}
	
	public void removeDestination() {
		destFloors.remove();
	}
}
