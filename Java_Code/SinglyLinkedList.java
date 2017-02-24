import java.util.*;
import static java.lang.System.*;

public class SinglyLinkedList
{
	private static class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}

	static int length = 0;
	static Node head = null;

	/** Insert new node at the starting of the list */
	public static Node insertAtStart(int data)
	{
		Node temp = new Node(data);
		if(head == null)
		{	
			head = temp;	
			length = 1;
		}
		else
		{
		temp.next = head;
		head = temp;
		}
		length += 1;
		return head;
	}

	/** Insert new node at the end of the list */
	public static Node insertAtEnd(int data)
	{
		Node temp = new Node(data);
		if(head == null)
		{
			head = temp;
			length = 1;
		}
		else
		{
			Node current = head;
			while(current.next != null)
				current = current.next;

			current.next = temp;
			temp.next = null;
			length += 1;	
		}		
		return head;
	}

	/** Insert new node at the given position */
	public static Node insertAtPosition(int position, int data)
	{
		if(position <= 0 || position > length + 1)
		{	
			out.println("Insertion not possible at this point");
			return head;
		}
		else if(position == 1)
			insertAtStart(data);
		else if(position == length + 1)
			insertAtEnd(data);
		else
		{
			Node temp = new Node(data);
			Node current = head;
			for(int i = 1; i < position - 1; i++)
				current = current.next;
			temp.next = current.next;
			current.next = temp;
			length += 1;
		}
		return head;
	}

	/** Display the List */
	public static void display(Node head)
	{
		out.print("HEAD->");
		Node current = head;
		if(head == null)
		{
			out.println("List is Empty");
			return ;
		}
		while(current != null)
		{
			out.print(current.data+"->");
			current = current.next;
		}

		out.println("NULL");	
	}

	/** Delete the node from the start of the list */
	public static Node deleteFromStart()
	{
		if(head == null)
		{
			out.println("Deletion not possible");
			return head;
		}
		Node temp = head;
		head = temp.next;
		length -= 1;
		return head;
	}

	/** Delete a node from the end of the list */
	public static Node deleteFromEnd()
	{
		if(head == null)
		{
			out.println("Deletion not possible");
			return head;
		}
		Node temp = head;
		Node current = head.next;

		while(current.next != null)
		{
			temp = temp.next;
			current = current.next;
		}
		temp.next = null;
		length -= 1;
		return head;
	}

	/** Delete a node at a given position */
	public static Node deleteAtPosition(int position)
	{
		if(position <= 0 || position > length)
		{
			out.println("Deletion not possible");
			return head;
		}
		else if(position == 1)
			deleteFromStart();
		else if(position == length)
			deleteFromEnd();		
		else
		{
			Node temp = head;
			Node current = head.next;
			for(int i = 1; i < position - 1; i++)
			{
				temp = temp.next;
				current = current.next;
			}
			temp.next = current.next;
			length -= 1;
		}	
		return head;
	}

	/** Find the middle element */
	public static int findMiddle()
	{
		Node temp = head;
		for(int i = 1; i <= (length / 2); i++)
			temp = temp.next;
		return temp.data;
	}

	/** Delete a node with given data */
	public static Node deleteWithData(int d)
	{
		Node temp = head;
		Node current = head.next;
		while(temp != null)
		{
			if(current.data == d)
				temp.next = current.next;
			temp = temp.next;
			current = current.next;

		}
		length -= 1;
		return head;
	}

	static public void main(String [] args)
	{
		Scanner sc = new Scanner(in);
		out.println("Enter the number of nodes to be inserted at first");
		int n = sc.nextInt();
		while(n -- > 0)
		{
			int data = sc.nextInt();
			insertAtEnd(data);
		}
		int choice = 0;
		char ans = ' ';
		do
		{
			out.println("Enter 1 for Insert");
			out.println("Enter 2 for Delete");
			out.println("Enter 3 for length of the List");
			out.println("Enter 4 to find the middle node of the list");
			out.println("Enter 5 for Display the List");
			out.println("Enter your choice from above");
			choice = sc.nextInt();

			switch(choice)
			{
				case 1:
					out.println("Enter the position at which insertion is to be done");
					int p = sc.nextInt();
					out.println("Enter the data to be inserted");
					int d = sc.nextInt();
					insertAtPosition(p, d);
					break;
				case 2:
					out.println("Enter the position at which insertion is to be done");
					int po = sc.nextInt();
					deleteAtPosition(po);
					break;
				case 3:
					out.println("The length of the List is:"+length);
					break;
				case 4:
					out.println("The middle if the List is:"+findMiddle());
					break;
				case 5:
					out.println("The list is:");
					display(head);	
					break;
				default:
					out.println("Invalid Choice enter your choice from above");
			}
			out.println("Want more(Y/n)");
			ans = sc.next().charAt(0);
		}
		while(ans == 'y' || ans == 'Y');
	}
}