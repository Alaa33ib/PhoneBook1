public class LinkedListEvent //LinkedList of Events
{

	private Node2 head;
	private Node2 current;	

	public LinkedListEvent()
   {
		head = current = null;
	}

	public boolean isEmpty()
   {
		return (head == null);
	}

	public boolean last()
   {
	  return (current.getNext() == null);
	}

	public void findFirst()
   {
		current = head;
	}

	public void findNext()
   {
	  current = current.getNext();
	}

	public Event retrieve()
   {
	  return current.getData();
	}

	public void update(Event data)
   {
	  current.setData(data);
	}

	public void insert(Event data)
   {
	  Node2 temp;
	  if(isEmpty()) 
       current = head = new Node2(data);
	  else 
     {
		 temp = current.getNext();
		 current.setNext(new Node2(data));
		 current = current.getNext();
		 current.setNext(temp);
	  }
	}
    
   public void remove()
   {
     if(current == head) 
       head = head.getNext();
    	else 
      {
    		Node2 temp = head;
    		while(temp.getNext() != current)
            temp = temp.getNext();
    		temp.setNext(current.getNext());	
    	}
    	if(current.getNext()!= null) 
        current = current.getNext();
    	else 
        current = head;
   }
    
  public boolean isNotATimeConflict(String dateAndTime)
  {
    Node2 temp = head; 
    while(temp != null) 
    {
      if(temp.getData().getDateAndTime().equalsIgnoreCase(dateAndTime))
        return false;
      temp = temp.getNext();
    }
    return true;
  } 

  public void deleteAll(String attribute, String criteria)
  {
     Node2 tmp = head;
     switch(criteria)
     {
      case "Name":
       
      while(tmp != null)
      {
        tmp.getData().getContactList().findFirst();
        while(!tmp.getData().getContactList().last())
        {  if(tmp.getData().getContactList().retrieve().getName().equalsIgnoreCase(attribute))
              tmp.getData().getContactList().remove();
           else
              tmp.getData().getContactList().findNext();
        }
        if(tmp.getData().getContactList().retrieve().getName().equalsIgnoreCase(attribute)) //checks last element
           tmp.getData().getContactList().remove();
        if(tmp.getData().getContactList().isEmpty())
        {
           current = tmp;
           this.remove();
           tmp = current;
        }
        else
         tmp = tmp.getNext();
      }
      break;
              
      case "Phone Number":
       
      while(tmp != null)
      {
        tmp.getData().getContactList().findFirst();
        while(!tmp.getData().getContactList().last())
        {  if(tmp.getData().getContactList().retrieve().getPhone().equalsIgnoreCase(attribute))
              tmp.getData().getContactList().remove();
           else
              tmp.getData().getContactList().findNext();
        }
        if(tmp.getData().getContactList().retrieve().getPhone().equalsIgnoreCase(attribute)) //checks last element
           tmp.getData().getContactList().remove();
        if(tmp.getData().getContactList().isEmpty()) //Event's contact list is empty
        {
           current = tmp;
           this.remove();
           tmp = current;
        }
        else
          tmp = tmp.getNext();
      }
      break;
    }
  }  
    
       
    public boolean searchE(String attribute, String criteria)
    {
      boolean flag = false; 
      Node2 temp = current;
     	current = head;
      Node2 nameS = head;
      
      switch(criteria) 
      {

       case "Title": //this criteria will adjust current if found
   
       while(current != null)
       {
     	   if(this.retrieve().getTitle().equalsIgnoreCase(attribute)) 
         { 
           System.out.println(this.retrieve().toString());
           return true;
         }
     	  current = current.getNext();
     	 }
     	 current = temp;
     	 return false;
       
      case "Contact Name":
      
      while(nameS != null)
      {
        nameS.getData().getContactList().findFirst();
        while(!nameS.getData().getContactList().last())
        {
     	    if(nameS.getData().getContactList().retrieve().getName().equalsIgnoreCase(attribute)) 
          { 
           System.out.println(nameS.getData().toString());
           flag = true;
          }
     	    nameS.getData().getContactList().findNext();
     	  }
        if(nameS.getData().getContactList().retrieve().getName().equalsIgnoreCase(attribute)) //checks last element
        { 
          System.out.println(nameS.getData().toString());
          flag = true;
        }
       nameS = nameS.getNext();
      }
      return flag;  
        
     default: 
     
     System.out.println("Please make sure criteria input is correct"); 
     return false;
    }
  }
  
  public void insertEvent(Event data)
  {
    Node2 ev = new Node2(data);
    if(isEmpty()) 
    { 
      current = head = ev;
      return;
    }  
      
    if(data.compareTo(head.getData()) < 0)
    {
    	ev.setNext(head);
      head = ev;
    }
     else
     {
      Node2 p = head, q = head.getNext();
      while(p.getNext() != null)
     	{ if((data.compareTo(p.getData()) >= 0) && (data.compareTo(q.getData()) < 0))
          break;
        p = p.getNext();
        q = q.getNext(); 
      }
      current = p;
      insert(data);
    } 
  } 

   public void display()
   {
     if(this.isEmpty())
       System.out.println("No events found");
     else
     {
       Node2 tmp = head;
       while(tmp != null)
       {
         System.out.println(this.retrieve().toString());
         tmp = tmp.getNext();
       }
     }
   }
   
   public void addContactToEvent(Contact contact) //needs to check if it exists in the list not done yet
   {
     this.retrieve().getContactList().insertContact(contact);
   }  
}

