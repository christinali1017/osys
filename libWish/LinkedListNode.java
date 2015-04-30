package libWish;

public class LinkedListNode {
	public int val;
	public LinkedListNode next;
	public LinkedListNode prev;
	public LinkedListNode last;

	LinkedListNode(int v, LinkedListNode n, LinkedListNode p) {
		val = v;
		setNext(n);
		setPrevious(p);
	}
	
	public void setNext(LinkedListNode n) {
		next = n;
		if (this == last) {
			last = n;
		}
		if (n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(LinkedListNode p) {
		prev = p;
		if (p != null && p.next != this) {
			p.setNext(this);
		}
	}
	
	public String toSting() {
		if (next != null) {
			return val + "->" + next.toSting();
		} else {
			return ((Integer) val).toString();
		}
	}
}
