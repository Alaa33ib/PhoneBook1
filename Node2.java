public class Node2 //Nodes that contain Event as data
{

    private Event data;
    private Node2 next;

    public Node2(Event s)
    {
	data = s;
	next = null;
    }
   
   public void setData(Event data)
   {
    this.data = data;
   }
   
   public Event getData()
   {
     return data;
   }

   public void setNext(Node2 next)
   {
	this.next = next;
   }
   
   public Node2 getNext()
   {
	return next;
   }
}
