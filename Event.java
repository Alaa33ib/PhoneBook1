public class Event implements Comparable {
    private String title;
    private String date;
    private String time;
    private String location;
    private String contactName;
    public LinkedListEvent events;
    //public LinkedListContact  ContactsInEvent;

    public Event() {
        this.title = "";
        this.date = null;
        this.time = "";
        this.location = "";
        this.events = new LinkedListEvent ();
    }

    public Event(String title, String date, String time, String location, String contactName, LinkedListEvent events) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.contactName = contactName;
        this.events = events;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public LinkedListEvent getEvents() {
        return events;
    }

    public void setEvents(LinkedListEvent events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return  "title=" + title + ", date=" + date + ", time=" + time + ", location=" + location + ", contactName=" + contactName + ", events=" + events ;
    }
    

     
    public Event Search_Event_byTitle(String t){
            
            if(events.isEmpty())
                return null;
            events.findFirst();
            while (!events. last())
            {
            if (events.retrieve().getTitle().equals (t)) 
            return events.retrieve();
            events.findNext();
            }
            if (events.retrieve().getTitle().equals (t)) 
            return events.retrieve();
           return null; 
    }
    
  /*  public LinkedListEvent Search_Event_byContactName(String n){
        
    }*/
            
    public boolean addEvent( Event e)
    {
        if (! events.isEmpty())
        {
            events.findFirst();
            for ( int i = 0 ; i < events.size ; i++)
            {
                if ((events.retrieve().date.compareTo(e.date) == 0) && (events.retrieve().time.compareTo(e.time) == 0))
                    return false;
            }
        }
         events.insert(e);
        return true;
    }
    
        public boolean CheckConflict(Event e){
            
        if(!events.isEmpty()) 
        {
           events.findFirst () ;
           int i = 0;
           while (i < events.size) {
           if((events.retrieve().date.compareTo(e.date)== 0) &&(events.retrieve().time.compareTo (e.time)==0)) {
           return false;
           }
           events.findNext ();
           i++;
           }
        }
          return true;
        }

  
    public int compareTo(Object obj) {
        
            return (this.title.compareToIgnoreCase(obj.title));
} 

    public void disply_events_alphabetically(){
        if (events.isEmpty()){
            System.out.println("No events found");
        }
        else{
            events.findFirst();
            for (int i=0;i< events.size;i++)
            {
              System.out.println((i+1) + ". Event : " + events.retrieve().title);
              events.findNext();
            }
        }
       
    } 
}
