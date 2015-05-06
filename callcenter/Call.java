package callcenter;


/**
 * Calls are first assigned to the employees who can handle it. 
 * @author wish
 */
public class Call {
	
	/**
	 * Type of employee handle the call
	 */
	private Level type;
	
	/**
	 * Person who call 
	 */
	private Caller caller;
	
	/**
	 * Person who handle this call
	 */
	private Employee handler;
	
	
	/**
	 * An incoming call is allocated to a fresher who is free, type is initialize as Fresh
	 * @param c : Caller
	 */
	public Call(Caller c) {
		this.caller = c;
		this.type = Level.Fresher;
	}
	
	public Level getLevel() {
		return type;
	}
	
	public void setLevel(Level t) {
		this.type = t;
	}
	
	public Employee getHandler() {
		return handler;
	}
	
	public void setHandler(Employee e) {
		this.handler = e;
	}
	
	public Caller getCaller() {
		return this.caller;
	}
	public Level escalateLevel() {
		if (type == Level.Fresher) {
			type = Level.TechnicalLeader;
		} else if (type == Level.TechnicalLeader) {
			type = Level.Manager;
		}
		
		//if type is manager, can not escalate anymore
		return type;
	}
	
	
	/**
	 * Hang up call
	 */
	public void hangUp() {
		//TODO
		System.out.println("Call is hung up");
	}
	

}
