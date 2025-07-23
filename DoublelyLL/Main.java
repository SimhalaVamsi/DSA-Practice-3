package DoublelyLL;

public class Main {

	public static void main(String[] args) {
		DLL dl=new DLL();
		dl.insertFirst(56);
		dl.insertFirst(12);
		dl.insertFirst(90);
		dl.insertFirst(23);
		dl.insertAtpos(2, 8);
		dl.insertLast(1);
		dl.display();

	}

}
