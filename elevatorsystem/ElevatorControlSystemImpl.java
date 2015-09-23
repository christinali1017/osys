package elevatorsystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Elevator control system class.
 * Contains basic elevator operations.
 * @author wish
 *
 */
public class ElevatorControlSystemImpl implements ElevatorControlSystem {
	/**
	 * Initial floor.
	 */
	private final static Integer INITIAL_FLOOR = 1;

	/**
	 * Number of elevators.
	 */
	private Integer numOfElevators;

	/**
	 * Number of floors.
	 */
	private Integer numOfFloors;

	/**
	 * List of elevators.
	 */
	private List<AbstractElevator> elevators;

	/**
	 * Peek up floors of elevator.
	 */
	private Queue<Integer> pickupFloors;

	/**
	 * Constructor.
	 * @param numOfElevators
	 * 			Number of elevators.
	 * @param numOfFloors
	 * 			Number of floors.
	 */			
	public ElevatorControlSystemImpl(Integer numOfElevators, Integer numOfFloors) {
		if (numOfElevators <= 0 || numOfFloors <= 0) {
			throw new IllegalArgumentException("number of elevators and number of floors must be positive");
		}
		this.numOfElevators = numOfElevators;
		this.numOfFloors = numOfFloors;
		initiate();
	}

	/**
	 * Initiate elevators and pickupFloors.
	 */
	private void initiate() {
		elevators = new ArrayList<AbstractElevator>();
		for (int i = 0; i < numOfElevators; i++) {
			elevators.add(new Elevator(INITIAL_FLOOR));
		}
		pickupFloors = new LinkedList<Integer>();
	}

	@Override
	public void addDestinationToElevator(Integer eleId, Integer destId) {
		elevators.get(eleId).addDestination(destId);
	}

	@Override
	public void pickUp(Integer floor) {
		pickupFloors.add(floor);
	}

	@Override
	public void step() {
		for (AbstractElevator el : elevators) {
			switch (el.getStatus()) {
			case IDLE:
				if (!pickupFloors.isEmpty()) {
					el.addDestination(pickupFloors.poll());
				}
				break;
			case OCCUPIED:
				switch (el.direction()) {
					case UP:
						el.moveUp();
						break;
					case DOWN:
						el.moveDown();
						break;
					case HOLD:
						el.removeDestination();
				}
				break;
			}
		}
	}
}
