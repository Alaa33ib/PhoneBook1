public class LinkedListContact //LinkedList of Contacts
{

	private Node1 head;
	private Node1 current;	

	public LinkedListContact()
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

	public Contact retrieve()
   {
	  return current.getData();
	}

	public void update(Contact data)
   {
	  current.setData(data);
	}

	public void insert(Contact data)
   {
	  Node1 temp;
	  if(isEmpty()) 
       current = head = new Node1(data);
	  else 
     {
		 temp = current.getNext();
		 current.setNext(new Node1(data));
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
    		Node1 temp = head;
    		while(temp.getNext() != current)
         {
    			temp = temp.getNext();
    		}
    		temp.setNext(current.getNext());	
    	}
    	if(current.getNext()!= null) 
        current = current.getNext();
    	else 
        current = head;
   }
    
   //end of ADT methods
    
    public boolean deleteContact(String attribute, String criteria) //deletes a contact from the list
    {
      Node1 tmp = head;
      Node1 prev = null;
      switch(criteria)
      {
       case "Name":
       
       while(tmp != null)
       {
         if(tmp.getData().getName().equalsIgnoreCase(attribute))
         {
           if(tmp == head) 
           {
             head = head.getNext();
             current = head;
           }
    	     else 
           {
    		    prev.setNext(tmp.getNext());	
             current = head;
           }
           return true;
         }
         prev = tmp;
         tmp = tmp.getNext();
       }
       return false;
       
       case "Phone Number":
       
       while(tmp != null)
       {
         if(tmp.getData().getPhone().equalsIgnoreCase(attribute))
         {
           if(tmp == head) 
           {
             head = head.getNext();
             current = head;
           }
    	     else 
           {
    		    prev.setNext(tmp.getNext());	
             current = head;
           }
           return true;
         }
         prev = tmp;
         tmp = tmp.getNext();
      }
      return false; 
     }
     return false;
   }
   
    
    public boolean search(String attribute, String criteria) //searches for a contact in the list based on a specific criteria
    {
      boolean flag = false; 
      Node1 temp = current;
     	current = head;
      
      switch(criteria) 
      {

       case "Name":
   
       while(current != null)
       {
     	   if(this.retrieve().getName().equalsIgnoreCase(attribute)) 
         { 
           System.out.println(this.retrieve().toString());
           return true;
         }
     	   current = current.getNext();
     	 }
     	 current = temp;
     	 return false;
       
      case "Phone Number":

      while(current != null)
      {
     	  if(this.retrieve().getPhone().equalsIgnoreCase(attribute)) 
        { 
          System.out.println(this.retrieve().toString());
          return true;
        }
     	  current = current.getNext();
     	}
      current = temp;
     	return false;
       
      case "Email Address":
     	
     	while(current != null)
      {
     	 if(this.retrieve().getEmail().equals(attribute))
       { 
         System.out.println(this.retrieve().toString());
     	   flag = true;
       }
     	 current = current.getNext();
      }
     	current = temp;
      return flag;
      
      
     case "Address":
 
     while(current != null)
     {
     	if(this.retrieve().getAddress().equals(attribute))
      { 
        System.out.println(this.retrieve().toString());
     	  flag = true;
      }
     	current = current.getNext();
     }
     current = temp;
     return flag;
     
     case "Birthday":

     while(current != null)
     {
     	if(this.retrieve().getBirthday().equals(attribute))
      { 
        System.out.println(this.retrieve().toString());
     	  flag = true;
      }
     	current = current.getNext();
     }
     current = temp;
     return flag;  
        
     default: 
     
     System.out.println("Please make sure criteria input is correct."); 
     return false;
     
    }
  }
  
  public void insertContact(Contact data) //inserts a contact into the list alphabetically 
  {
    Node1 con = new Node1(data);
    if(isEmpty()) 
    { 
      current = head = con;
      return;
    }  
      
    if(data.compareTo(head.getData()) < 0)
    {
    	con.setNext(head);
      head = con;
    }
    else
    {
      Node1 p = head, q = head.getNext();
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
  
  public void display() //displays all contacts in the list; for testing purposes only
  {
     Node1 tmp = head;
     while(tmp != null)
     {
       System.out.println(tmp.getData().toString());
       tmp = tmp.getNext();
     }
  }
  
}



