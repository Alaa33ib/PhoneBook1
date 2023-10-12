public class Node1 //Nodes that contain Contact as data
{

	private Contact data;
	private Node1 next;

	public Node1(Contact s)
   {
	  data = s;
	  next = null;
	}
   
   public void setData(Contact data)
   {
     this.data = data;
   }
   
   public Contact getData()
   {
     return data;
   }

	public void setNext(Node1 next)
   {
	  this.next = next;
	}
   
	public Node1 getNext()
   {
	  return next;
	}

}