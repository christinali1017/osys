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
		System.out.println("Call " + c.getCaller().getName() + " is being handling");
		this.call = c;
		
		Thread t = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finishCall();
			}
				
		});
		
		t.start();
	}
	
	/**
	 * When employee finishes a call, pick up a new call in queue
	 */
	public boolean pickupNewCall() {
		if (call == null) {
			CallDispatcher.getInstance().handleCall(this);
			return true;
		}
		return false;
	}
	
	/**
	 * If can not solve this problem, escalate it to the upper level.
	 * Fresher should escalate to the Technical Leader
	 * Technical Leader should escalate to the Product manager
	 */
	public void escalate() {
		if (call != null) {
			call.escalateLevel();
			CallDispatcher.getInstance().dispatchCall(call);
			call = null;
		}
		CallDispatcher.getInstance().handleCall(this);
	}
	
	/**
	 * Finish and disconnect current call. 
	 */
	public void finishCall() {
		/*set current call to null*/
		if (call != null) {
			call.hangUp();
			call = null;
		}
		
		/*pick up new call, if there are calls in queue*/
		CallDispatcher.getInstance().handleCall(this);
		
	}
	
	
}
