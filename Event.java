public class Event implements Comparable 
{
    private String title, dateAndTime, location;
    public LinkedListContact contactList = new LinkedListContact(); //contacts associated with each event

    public Event() //default constructor
    {
       title = dateAndTime = location = "";
    }

    public Event(String title, Contact contact, String dateAndTime, String location) 
    {
        this.title = title;
        this.dateAndTime = dateAndTime;
        this.location = location;
        contactList.insertContact(contact);
    }

    public String getTitle() 
    {
        return title;
    }

    public String getDateAndTime() 
    {
        return dateAndTime;
    }

    public String getLocation() 
    {
        return location;
    }
    
    public LinkedListContact getContactList()
    {
        return contactList;
    }
 
    public String toString() 
    {
        return  "Title: " + title + " - Date and Time: " + dateAndTime +  " - Location: " + location;
    }

    public int compareTo(Object s) 
    {  
      Event str = (Event)s;
      int firstLength = this.getTitle().length();  
      int secondLength = str.getTitle().length();  
      int minLength = Math.min(firstLength, secondLength);
      int i = 0;  
      while(i < minLength) 
      {  
       char ch1 = this.getTitle().charAt(i);  
       char ch2 = str.getTitle().charAt(i);  
       if(ch1 != ch2) 
       {  
        if((int)(ch1-ch2) > 0)
         return 1;
         else
        return -1;
       }
      i++;  
     }  
    return 0;  
   }           
} 
