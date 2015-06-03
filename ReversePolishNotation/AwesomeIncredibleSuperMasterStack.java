package ReversePolishNotation;
public class AwesomeIncredibleSuperMasterStack<T> 
{
	private int total;
	private Node first;

	class Node
	{
		private T element;
		private Node next;

		public Node(T element, Node next)
		{
			this.element = element;
			this.next = next;
		}
	}
	

	public AwesomeIncredibleSuperMasterStack()
	{

	}
	public AwesomeIncredibleSuperMasterStack<T> push (T newElement)
	{
		first = new Node(newElement, first);
		total++;
		return this;
	}

	public T pop() throws UnderflowException
	{
		if(first == null) throw new UnderflowException();
		T element = first.element;
		first = first.next;
		total--;

		return element;
	}

	public boolean isEmpty()
	{
		return (first == null);
	}



	public T peek() throws UnderflowException
	{
		T element = this.pop();
		this.push(element);

		return element;
	}

	@Override
	public String toString() 
	{
		String returnString = "";
		try
		{
			AwesomeIncredibleSuperMasterStack<T> maStash = new AwesomeIncredibleSuperMasterStack<T>();

			while(!this.isEmpty())
				maStash.push(this.pop());		

			while(!maStash.isEmpty())
			{
				returnString += maStash.peek().toString() + " ";
				this.push(maStash.pop());
			}
		}
		catch(UnderflowException exception)
		{

		}
		return returnString; 
	}

}
