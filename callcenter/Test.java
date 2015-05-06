package callcenter;

public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CallDispatcher callDispatcher = CallDispatcher.getInstance();
		Call c1 = new Call(new Caller("A", "1"));
		Call c2 = new Call(new Caller("B", "2"));
		Call c3 = new Call(new Caller("C", "3"));
		Call c4 = new Call(new Caller("D", "4"));
		Call c5 = new Call(new Caller("E", "5"));
		Call c6 = new Call(new Caller("F", "6"));
		Call c7 = new Call(new Caller("G", "7"));
		Call c8 = new Call(new Caller("H", "8"));
		Call c9 = new Call(new Caller("I", "10"));
		Call c10 = new Call(new Caller("J", "11"));
		Call c11= new Call(new Caller("K", "12"));
		Call c12 = new Call(new Caller("L", "13"));
		
		callDispatcher.dispatchCall(c1);
		callDispatcher.dispatchCall(c2);
		callDispatcher.dispatchCall(c3);
		callDispatcher.dispatchCall(c4);
		callDispatcher.dispatchCall(c5);
		callDispatcher.dispatchCall(c6);
		callDispatcher.dispatchCall(c7);
		callDispatcher.dispatchCall(c8);
		callDispatcher.dispatchCall(c9);
		callDispatcher.dispatchCall(c10);
		callDispatcher.dispatchCall(c11);
		callDispatcher.dispatchCall(c12);
	}

}
