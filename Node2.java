public class Node2 {

	private Event data;
	private Node2 next;

	public Node2(Event s){
		data = s;
		next = null;

	}
   
   public void setData(Event data){
   this.data=data;}
   public Event getData(){
   return data;}

	public void setNext(Node2 n){
		next = n;
	}
	public Node2 getNext(){
		return next;
	}



}