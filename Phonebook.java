import java.util.*;
public class Phonebook
{
 static Scanner key = new Scanner(System.in);
 public static void main(String [] args)
 {
   
   
   LinkedListContact Phonebook = new LinkedListContact();
   LinkedListEvent Events = new LinkedListEvent();
   
   key.useDelimiter("\n");
   System.out.println("Welcome to the Linked Tree Phonebook!");
   boolean menuFlag = true;
   
   do 
   {
      System.out.println("Please choose an option:");
      System.out.println("1.Add a contact");
      System.out.println("2.Search for a contact");
      System.out.println("3.Delete a contact");
      System.out.println("4.Schedule an event");
      System.out.println("5.Print event details");
      System.out.println("6.Print contacts by first name");
      System.out.println("7.Print all events alphabetically");
      System.out.println("8.Print all contacts attending an event");
      System.out.println("9.Add a contact to a scheduled event");
      System.out.println("10.Exit");
      System.out.println();
      System.out.print("Enter your choice: ");
      int criteria = key.nextInt();
      
      
      switch (criteria)
      {
        case 1:
        
        System.out.print("Enter the contact's name(FirstName LastName): ");
        String name = key.next();
        if(Phonebook.search(name, "Name"))
        {
          System.out.println("Contact already exists in phonebook, look above, addition is rejected.");
          continue;
        } 
        System.out.print("Enter the contact's phone number: ");
        String phoneNum = key.next();
        if(Phonebook.search(phoneNum, "Phone Number"))
        {
           System.out.println("Contact already exists in phonebook, look above, addition is rejected.");
           continue;
        }
        System.out.print("Enter the contact's email address: ");
        String email = key.next();
        System.out.print("Enter the contact's address: ");
        String address = key.next();
        System.out.print("Enter the contact's birthday: ");
        String birthday = key.next();
        System.out.print("Enter any notes for the contact: ");
        String notes = key.next();
        System.out.println();        
        Phonebook.insertContact(new Contact(name, phoneNum, email, address, birthday, notes));
        System.out.println("Contact added successfully!");
        System.out.println();        
        break; 
        
        case 2:
        
        System.out.println("Enter search criteria:");
        System.out.println("1.Name");
        System.out.println("2.Phone Number");
        System.out.println("3.Email Address");
        System.out.println("4.Address");
        System.out.println("5.Birthday");
        System.out.print("Enter your choice: ");
        criteria = key.nextInt();
        
          switch (criteria)
          {
            case 1:
            
            System.out.print("Enter the contact's name: ");
            name = key.next();
            System.out.println();
            if(!Phonebook.search(name, "Name")) //case it is found will be printed by the method itself! 
              System.out.println("Contact not found!");
            else        
              System.out.println("Look above, contact found!");    
            System.out.println();
            break;     
               
            case 2:
            
            System.out.print("Enter the contact's phone number: ");
            phoneNum = key.next();
            System.out.println();
            if(!Phonebook.search(phoneNum, "Phone Number")) //case it is found will be printed by the method itself!
               System.out.println("Contact not found!"); 
            else        
              System.out.println("Look above, contact found!");    
            System.out.println();
            break; 
            
            case 3:
            
            System.out.print("Enter the contact's email address: ");
            email = key.next();
            System.out.println();
            if(!Phonebook.search(email, "Email Address")) //case it is found will be printed by the method itself!
               System.out.println("Contact not found!"); 
            else        
              System.out.println("Look above, contact(s) found!");  
            System.out.println();
            break; 
            
            case 4:
            
            System.out.print("Enter the contact's address: ");
            address = key.next();
            System.out.println();
            if(!Phonebook.search(address, "Address")) //case it is found will be printed by the method itself! 
               System.out.println("Contact not found!"); 
            else        
              System.out.println("Look above, contact(s) found!");  
            System.out.println();
            break; 

            case 5:
            
            System.out.print("Enter the contact's birthday: ");
            birthday = key.next();
            System.out.println();
            if(!Phonebook.search(birthday, "Birthday")) //case it is found will be printed by the method itself!
               System.out.println("Contact not found!"); 
            else        
              System.out.println("Look above, contact(s) found!");  
            System.out.println();
            break; 
             
            default:
            
            System.out.println();
            System.out.println("You entered a number outside the allowed range, try again!\n");
            break;
          }
         break;
         
         case 3:
         
         System.out.println("Enter delete criteria: ");
         System.out.println("1.Name");
         System.out.println("2.Phone Number");
         System.out.print("Enter your choice: ");
         criteria = key.nextInt();
         if (criteria == 1)
         { 
          System.out.print("Enter the contact's name: ");
          name = key.next();
          System.out.println();
          if(Phonebook.deleteContact(name, "Name")) //method will look for the contact that will be deleted and return true if the operation is successful
          { 
           Events.deleteAll(name, "Name"); //method in event's data structure that deletes events based on contact's name or phone number
           System.out.println("Contact successfully deleted!");
          }
          else
           System.out.println("Contact couldn't be found, deletion is not successful!");
           System.out.println();
         }
         else if (criteria == 2)
         { 
          System.out.print("Enter the contact's phone number: ");
          phoneNum = key.next();
          System.out.println();
          if(Phonebook.deleteContact(phoneNum, "Phone Number"))
          { 
           Events.deleteAll(phoneNum, "Phone Number");
           System.out.println("Contact successfully deleted!");
          }
          else
            System.out.println("Contact couldn't be found, deletion is not successful!");
          System.out.println();
         }
         else
         {
           System.out.println();
           System.out.println("You entered a number outside the allowed range, try again!\n");
         }
         break;
         
         case 4: 
     
         System.out.print("Enter the event's title: "); //make a uniqueness constraint here
         String title = key.next();
         System.out.print("Enter the contact name: ");
         String contactName = key.next();           
         System.out.print("Enter the event's date and time(MM/DD/YYYY HH:MM): ");
         String dateAndTime = key.next();
         System.out.print("Enter the event's location: ");
         String location = key.next();
         System.out.println();
         if(Events.isNotATimeConflict(dateAndTime)) //search sets found element as current
         {
          if(Phonebook.search(contactName, "Name")) 
          { 
            System.out.println("Event will be scheduled with the contact above.");
            Events.insertEvent(new Event(title, Phonebook.retrieve(), dateAndTime, location));
            System.out.println("Event scheduled successfully!");
          }
          else
            System.out.println("Contact not found!");
         }
         else
          System.out.println("Event couldn't be scheduled because of a time conflict!"); 
        System.out.println();
        break; 
        
        case 5: //fix spacing here
        
        System.out.println("Enter search criteria:");
        System.out.println("1.Contact name");
        System.out.println("2.Event title");
        System.out.print("Enter your choice: ");
        criteria = key.nextInt();
        if (criteria == 1)
        {
         System.out.print("Enter the contact's name: ");
         contactName = key.next();
         if(!Phonebook.search(contactName, "Name"))
           System.out.println("Contact with this name is not found");
         else
         {
          System.out.println("The contact exists and these are the events scheduled with it: "); 
          Events.searchE(contactName, "Contact Name");
         }
        }    
        else if (criteria == 2)
        {
         System.out.print("Enter the event's title: ");
         title = key.next();
         if(!Events.searchE(title, "Title")) //case it is found will be printed by the method itself exactly like phonebook search
           System.out.println("Event not found!"); 
        }    
        break; 
        
        case 6:
        
        System.out.print("Enter the first name: ");
        name = key.next();
        displayByFirstName(Phonebook, name); //calls static display method 
        break;
        
        case 7: //doesnt work properly the method
        
        Events.display();
        System.out.println();
        break; 
        
        case 8:
        
        System.out.print("Please enter event title: ");
        title = key.next();
        contactsByEvent(Events, title);
        break; 
        
        case 9:
        
        System.out.print("Please enter event title: ");
        title = key.next();
        if(!Events.searchE(title, "Title"))
          System.out.println("Event not found!");
        else
        {
          System.out.println("Contact will be added to the event above!");
          System.out.print("Enter contact name: ");
          name = key.next();
          if(!Phonebook.search(name, "Name")) //case it is found will be printed by the method itself! 
               System.out.println("Contact not found"); 
          else
          {
            System.out.println("Contact above will be added to this event!");
            Events.addContactToEvent(Phonebook.retrieve());
            System.out.println("Contact added successfully!");
          }
        }
        break;
        
        case 10:
        
        menuFlag = false;
        break;
        
        default:
        
        System.out.println("You entered a number outside the allowed range, try again!");
        break;
      }
   }while(menuFlag);
   
   Events.findFirst(); //testing
   while(!Events.last())
    { System.out.println(Events.retrieve().toString());
      Events.findNext(); }
   System.out.println(Events.retrieve().toString());
    

 }
 
 //contacts by first name method
 public static void displayByFirstName(LinkedListContact list, String firstName)
 {
  list.findFirst();
  while(!list.last())
  { 
    if(firstName.equalsIgnoreCase(list.retrieve().getName().substring(0,list.retrieve().getName().indexOf(' '))))
      System.out.println(list.retrieve().toString());
    list.findNext();
  }
  if(firstName.equalsIgnoreCase(list.retrieve().getName().substring(0,list.retrieve().getName().indexOf(' '))))
    System.out.println(list.retrieve().toString());
 }
 
 //contacts by shared event method
 public static void contactsByEvent(LinkedListEvent list, String eventName)
 {
    if(!list.searchE(eventName,"Title"))
      System.out.println("Event not found");
    else
    {
      System.out.println("All contacts belonging to the event above: ");
      list.retrieve().getContactList().findFirst();
      while(!list.retrieve().getContactList().last())
      {
         System.out.println(list.retrieve().getContactList().retrieve().toString());
         list.retrieve().getContactList().findNext();
      }
      System.out.println(list.retrieve().getContactList().retrieve().toString());
    } 
 }
} 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
