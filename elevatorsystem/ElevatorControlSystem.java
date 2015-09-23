package elevatorsystem;

/**
 * Elevator control system interface.
 * @author wish
 *
 */
public interface ElevatorControlSystem {
	public void addDestinationToElevator(Integer eleId, Integer destId);
	
	public void pickUp(Integer floor);
	
	public void step();
}
