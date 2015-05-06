package callcenter;

/**
 * Super class of employees, it is implemented as abstract class. There are three levels of employees, Fresher,
 * Technical Leader(TL), Product Manager(PM). Multiple employees, only one TL or PM
 
 * @author wish
 * @date 05/02/2015
 */
public abstract class Employee {
	
	/**
	 * Employee type
	 */
	protected Level level;
	
	/**
	 * Current call, if call is null, then indicated that the employee is free
	 */
	protected Call call ; 
	
	public Employee() {
		call = null;
	}
	
	/**
	 * @return Employee type
	 */
	public Level getLevel() {
		return level;
	}
	
	/**
	 * If current call is null, then the employee is free
	 * @return If an employee if free.
	 */
	public boolean isFree() {
		return call == null;
	}
	
	/**
	 * Handle new Call. 
	 */
	public void handleCall(Call c) {
		this.call = c;
	}
	
	/**
	 * If can not solve this problem, escalate it to the upper level.
	 * Fresher should escalate to the Technical Leader
	 * Technical Leader should escalate to the Product manager
	 */
	public void escalate() {
		//TODO
	}
}
