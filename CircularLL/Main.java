package CircularLL;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CLL list =new CLL();
		//Inserting elements at first position.
		list.insert(3);
		list.insert(73);
		list.insert(21);
		list.insert(9);
		list.insert(45);
		list.insertAtPos(2, 67);
		list.display();
		//Deleting element at first.
		System.out.println("deleted element at first is: "+list.deleteFirst());
		list.display();
		//Deleting element at last.
		System.out.println("deleted element at last is: "+list.deleteLast());
		list.display();
		//Deleting element at particular position node.
		System.out.println("deleted element at given index is: "+list.delete(3));
		list.display();
		//searching for a element in the list.
		System.out.println(list.find(21));
	}

}
