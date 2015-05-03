package callcenter;


/**
 * @author wish
 *
 */
public class Call {
	
	/**
	 * Type of employee handle the call
	 */
	private Type type;
	
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
		this.type = Type.Fresher;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type t) {
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
	public Type escalateType() {
		if (type == Type.Fresher) {
			type = Type.TechnicalLeader;
		} else if (type == Type.TechnicalLeader) {
			type = Type.Manager;
		}
		
		//if type is manager, can not escalate anymore
		return type;
	}
	
	
	/**
	 * Hang up call
	 */
	public void hangUp() {
		//TODO
	}
	

}
