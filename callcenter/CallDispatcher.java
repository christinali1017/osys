package callcenter;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * CallDispatcher is used to dispatcher calls. All calls should first go to call dispatcher.
 * Thus we design CallDispatcher as a singleton class 
 * @author wish
 */
public class CallDispatcher {
	/* Number of freshers, technical lead and managers*/
	private final int TOTAL_FRESHER = 20;
	private final int TOTAL_TECHNICALLEAD = 4;
	private final int TOTAL_MANAGER = 2;
	
	/**
	 * Total levels of employees
	 */
	private final int LEVELS = 3;
	
	/**
	 * CallDispatcher instance
	 */
	private static CallDispatcher callDispatcher;
	
	/**
	 * List of employees
	 * List[0] -- Freshers
	 * List[1] -- Technical Lead
	 * List[2] -- Managers
	 */
	List<List<Employee>> employees;
	
	/**
	 * Queue of calls
	 */
	List<Deque<Call>> callDeque;
	
	private CallDispatcher() {
		/*initiated employees*/
		this.employees = new ArrayList<List<Employee>>(LEVELS);
		
		List<Employee> freshers = new ArrayList<Employee>(TOTAL_FRESHER);
		for (int i = 0; i < TOTAL_FRESHER; i++) {
			freshers.add(new Fresher());
		}
		employees.add(freshers);
		
		List<Employee> technicalLead = new ArrayList<Employee>(TOTAL_TECHNICALLEAD);
		for (int i = 0; i < TOTAL_TECHNICALLEAD; i++) {
			technicalLead.add(new TechnicalLead());
		}
		employees.add(technicalLead);
		
		List<Employee> manager = new ArrayList<Employee>(TOTAL_MANAGER);
		for (int i = 0; i < TOTAL_MANAGER; i++) {
			manager.add(new Manager());
		}
		employees.add(manager);
		
		/*initiated call queue*/
		callDeque = new ArrayList<Deque<Call>>();
	}
	
	
	/**
	 * @return CallDispatcher instance
	 */
	public static CallDispatcher getInstance() {
		if (callDispatcher == null) {
			synchronized(CallDispatcher.class) {
				callDispatcher = new CallDispatcher();
			}
		}
		return callDispatcher;
	}
	
	/**
	 * Dispatch a call to an employee(Including three types of employees) from lower level to higher level
	 * If no employees is available, then save the call to 
	 * the call queue
	 * 
	 */
	public void dispatchCall(Call c) {
		Employee handler = null;
		int level = c.getLevel().getValue();
		/*Get handler, low to high*/
		for (int i = level; i < LEVELS; i++) {
			List<Employee> cur = employees.get(i);
			for (Employee e : cur) {
				if (e.isFree()) {
					handler = e;
					break;
				}
			}
		}
		
		/* if all employees are busy, put call into queen. Otherwise, handle call*/
		if (handler == null) {
			System.out.println("Service is busy now, please wait.. Thanks");
			callDeque.get(level).addLast(c);
			return;
		}
		
		/*Handle call*/
		handler.handleCall(c);
		c.setHandler(handler);
	}
	
	
	
	/**
	 * If an Employee is available, handle call
	 * An employee handles the first coming call
	 * Also, it handles from the highest level he/she can handle
	 */
	public boolean handleCall(Employee e) {
		int level = e.getLevel().getValue();
		
		for (int i = level; i >= 0; i--) {
			Deque<Call> queue = callDeque.get(i);
			if (!queue.isEmpty()) {
				Call c = queue.pollFirst();
				e.handleCall(c);
				return true;
			}
		}
		System.out.println("No call to handle");
		return false;
	}
	
	
}
