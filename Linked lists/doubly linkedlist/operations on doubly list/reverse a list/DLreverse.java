/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication92;

public class DLreverse {

   Node head; // head of list

	/* Linked list Node*/
	class Node
	{
		int data;
		Node next,prev;
		Node(int d) {data = d;}
	}

	/* Inserts a new Node at front of the list. */
	public void push(int new_data)
	{
		/* 1 & 2: Allocate the Node &
				Put in the data*/
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/* Inserts a new node after the given prev_node. */
	public void insertAfter(Node prev_node, int new_data)
	{
		/* 1. Check if the given Node is null */
		if (prev_node == null)
		{
			System.out.println("The given previous node cannot be null");
			return;
		}

		/* 2 & 3: Allocate the Node &
				Put in the data*/
		Node new_node = new Node(new_data);

		/* 4. Make next of new Node as next of prev_node */
		new_node.next = prev_node.next;

		/* 5. make next of prev_node as new_node */
		prev_node.next = new_node;
	}

	/* Appends a new node at the end. This method is
	defined inside LinkedList class shown above */
	public void append(int new_data)
	{
		/* 1. Allocate the Node &
		2. Put in the data
		3. Set next as null */
		Node new_node = new Node(new_data);

		/* 4. If the Linked List is empty, then make the
			new node as head */
		if (head == null)
		{
			head = new Node(new_data);
			return;
		}

		/* 4. This new node is going to be the last node, so
			make next of it as null */
		new_node.next = null;

		/* 5. Else traverse till the last node */
		Node last = head;
		while (last.next != null)
			last = last.next;

		/* 6. Change the next of last node */
		last.next = new_node;
                new_node.prev=last;
		return;
	}

	/* This function prints contents of linked list starting from
		the given node */
	public void printList()
	{
		Node tnode = head;
		while (tnode != null)
		{
			System.out.print(tnode.data+" ");
			tnode = tnode.next;
		}
	}

        public void DoReverse(Node node){
        if(node!=head){
        Node start=head;  //extra pointer 1
        while(start.next!=node){
        start=start.next;

        }
        
        start.next=start.prev;
        start.prev=node;

        }
        else{head=get();}


        }
        Node get(){
        Node n=head;
        while(n.next!=null){
        n=n.next;}
        return n;
        }

	/* Driver program to test above functions. Ideally this function
	should be in a separate user class. It is kept here to keep
	code compact */
	public static void main(String[] args)
	{
		/* Start with the empty list */
		DLreverse llist = new DLreverse();

	llist.append(1);
        llist.append(2);
        llist.append(3);
        llist.append(4);
        llist.append(5);
        llist.append(6);
        llist.append(8);
        llist.append(9);
        llist.append(0);
        llist.append(2);
		System.out.println("\nCreated Linked list is: ");

		llist.printList();
                System.out.println("Reverse Linked list is: ");
                llist.get();
               //llist.DoReverse(null);
               //llist.printList();
	}
   
}
