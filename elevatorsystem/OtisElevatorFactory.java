package elevatorsystem;

/**
 * A specific Elevator factory Otis. 
 * 
 * @author wish
 */
public class OtisElevatorFactory implements ElevatorFactory {

	/**
	 * @param number: identifier of a elevator
	 * @param currentFloor: current floor
	 */
	@Override
	public Elevator createElevator(int number, int initiateFloor) {
		return new OtisElevator(number, initiateFloor);
	}
	
}
