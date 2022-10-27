import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {
	private ListNode last;
	private int length;
	private class ListNode{
		private int data;
		private ListNode next;
		public ListNode(int data) {
			this.data=data;
		}
	}
	public CircularSinglyLinkedList() {
		last=null;
		length=0;
	}
	public int length() {
		return length;
	}
	public boolean isEmpty() {
		return length==0;
	}
	public void createCircularLinkedList() {
		ListNode first=new ListNode(1);
		ListNode second=new ListNode(4);
		ListNode third=new ListNode(8);
		ListNode fourth=new ListNode(16);
		first.next=second;
		second.next=third;
		third.next=fourth;
		fourth.next=first;
		last=fourth;
	}
	public void display() {
		if(last==null) {
			return;
		}
		ListNode first=last.next;
		while(first!=last) {
			System.out.print(first.data+" --> ");
			first=first.next;
		}
		System.out.print(first.data);
	}
	public void insertFirst(int value) {
		ListNode newNode=new ListNode(value);
		if(last==null) {
			last=newNode;
		}else {
			newNode.next=last.next;
		}
		last.next=newNode;
		length++;
	}
	public void insertLast(int value) {
		ListNode newNode=new ListNode(value);
		if(last==null) {
			last=newNode;
			last.next=last;
		}else {
			newNode.next=last.next;
			last.next=newNode;
			last=newNode;
		}
		length++;
	}
	public void deleteFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp=last.next;
		if(last.next==last) {
			last=null;
		}else {
			last.next=temp.next;
		}
		temp.next=null;
		length--;
	}
	public static void main(String args[]) {
		CircularSinglyLinkedList cl=new CircularSinglyLinkedList();
		cl.createCircularLinkedList();
		cl.display();
		System.out.println();
		cl.insertFirst(0);
		cl.display();
		System.out.println();
		cl.insertLast(18);
		cl.display();
		System.out.println();
        cl.deleteFirst();
        cl.display();
	}

}
