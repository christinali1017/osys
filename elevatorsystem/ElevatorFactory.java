package elevatorsystem;

/**
 * The interface for Elevator Factory. It defines the behavior shared by all Elevator factories. 
 * @author wish
 */
public interface ElevatorFactory {
	public Elevator createElevator(int elevetorNumber, int currentFloor);
}
