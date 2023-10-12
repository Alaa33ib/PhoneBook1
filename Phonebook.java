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
      System.out.println("8.Exit");
      System.out.println();
      System.out.print("Enter your choice: ");
      int choice = key.nextInt();
      
      
      switch (choice)
      {
        case 1:
        
        System.out.println("Enter the contact's name: ");
        String name = key.next();
        if(Phonebook.search(name, "Name"))
        {
          System.out.println("Contact already exists in phonebook, look above, addition is rejected.");
          continue;
        } 
        System.out.println("Enter the contact's phone number: ");
        String phoneNum = key.next();
        if(Phonebook.search(phoneNum, "Phone Number"))
        {
           System.out.println("Contact already exists in phonebook, look above, addition is rejected.");
           continue;
        }
        System.out.println("Enter the contact's email address: ");
        String email = key.next();
        System.out.println("Enter the contact's address: ");
        String address = key.next();
        System.out.println("Enter the contact's birthday:");
        String birthday = key.next();
        System.out.println("Enter any notes for the contact: ");
        String notes = key.next();
        Phonebook.insertContact(new Contact(name, phoneNum, email, address, birthday, notes));
        System.out.println("Contact added successfully!");
        
        break; 
        
        case 2:
        
        System.out.println("Enter search criteria:");
        System.out.println("1.Name");
        System.out.println("2.Phone Number");
        System.out.println("3.Email Address");
        System.out.println("4.Address");
        System.out.println("5.Birthday");
        System.out.print("Enter your choice: ");
        int criteria = key.nextInt();
        
          switch (criteria)
          {
            case 1:
            
            System.out.println("Enter the contact's name: ");
            name = key.next();
            if(!Phonebook.search(name, "Name")) //case it is found will be printed by the method itself! 
               System.out.println("Contact not found"); 
            break;     
               
            case 2:
            
            System.out.println("Enter the contact's phone number: ");
            phoneNum = key.next();
            if(!Phonebook.search(phoneNum, "Phone Number")) //case it is found will be printed by the method itself!
               System.out.println("Contact not found"); 
            break; 
            
            case 3:
            
            System.out.println("Enter the contact's email address: ");
            email = key.next();
            if(!Phonebook.search(email, "Email")) //case it is found will be printed by the method itself!
               System.out.println("Contact not found"); 
            break; 
            
            case 4:
            
            System.out.println("Enter the contact's address: ");
            address = key.next();
            if(!Phonebook.search(address, "Address")) //case it is found will be printed by the method itself! 
               System.out.println("Contact not found"); 
            break; 

            case 5:
            
            System.out.println("Enter the contact's birthday: ");
            birthday = key.next();
            if(!Phonebook.search(birthday, "Birthday")) //case it is found will be printed by the method itself!
               System.out.println("Contact not found"); 
            break; 
             
            default:
        
            System.out.println("You entered a number outside the allowed range, try again!");
            break;
          }
         break;
         
         case 3:
         
         System.out.println("Enter delete criteria: ");
         System.out.println("1.Name");
         System.out.println("2.Phone Number");
         criteria = key.nextInt();
         if (criteria == 1)
         { 
          System.out.print("Enter the contact's name: ");
          name = key.next();
          if(Phonebook.delete(name, "Name")) //method will look for the contact that will be deleted and return true if the operation is successful
          { 
           Events.deleteAll(name, "Name"); //method in event's data structure that deletes events based on contact's name or phone number
           System.out.println("Contact successfully deleted");
          }
          else
           System.out.println("Contact couldn't be found, deletion is not successful");
         }
         else if (criteria == 2)
         { 
          System.out.print("Enter the contact's phone number: ");
          phoneNum = key.next();
          if(Phonebook.delete(phoneNum, "Phone Number"))
          { 
           Events.deleteAll(phoneNum, "Phone Number");
           System.out.println("Contact successfully deleted");
          }
          else
            System.out.println("Contact couldn't be found, deletion is not successful");
         }
         else
           System.out.println("You entered a number outside the allowed range, try again!");
         break;
         
         case 4:
     
         System.out.print("Enter the event's title: ");
         String title = key.next();
         System.out.print("Enter the contact name: ");
         contactName = key.next();           
         System.out.print("Enter the event's date and time(MM/DD/YYYY HH:MM): ");
         String dateAndTime = key.next();
         System.out.print("Enter the event's location: ");
         String location = key.next();
         if(Phonebook.search(contactName, "Name") && Events.isNotATimeConflict(dateAndTime)) //search sets found element as current
         {
          System.out.println("Event will be scheduled with the contact above");
          Events.insertEvent(new Event(title, Phonebook.retrieve(), dateAndTime, location)); 
          Phonebook.retrieve().getEventList().insertEvent(new Event(title, dateAndTime, location)); //event has a constructor that doesn't require a contact
          System.out.println("Event scheduled successfully!");
         }
         else
          System.out.println("Event couldn't be scheduled because of a contact and/or time conflict!"); 
        break; 
        
        case 5:
        
        System.out.println("Enter search criteria:");
        System.out.println("1.Contact name");
        System.out.println("2.Event title");
        System.out.print("Enter your choice: ");
        int criteria = key.nextInt();
        if (criteria == 1)
        {
         System.out.println("Enter the contact's name: ");
         String name = key.next();
         if(!Phonebook.search(name, "Name"))
           System.out.println("Contact with this name is not found");
         else
         {
          System.out.println("If event is found, it belongs to the contact above."); 
          if(!Events.search(name, "Name")) //case it is found will be printed by the method itself 
           System.out.println("Event not found"); 
        }    
        else if (criteria == 2)
        {
         System.out.println("Enter the event's title: ");
         String title = key.next();
         if(!Events.search(title, "Title")) //case it is found will be printed by the method itself exactly like phonebook search
           System.out.println("Event not found"); 
        }    
        break; 
        
        case 6:
        
        System.out.println("Enter the first name: ");
        name = key.next();
        displayByFirstName(Phonebook, name); //calls static display method 
        break;
        
        case 7:
        
        Events.display(); //events will be inserted alphabetically so this method just loops them
        break; 
        
        case 8:
        
        menuFlag = false;
        break;
        
        default:
        
        System.out.println("You entered a number outside the allowed range, try again!");
        break;
      }
   }while(menuFlag);
   
   Phonebook.findFirst();
        
        while(!Phonebook.last())
        { System.out.println(Phonebook.retrieve());
         Phonebook.findNext();
        }
        System.out.println(Phonebook.retrieve());


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
    if(!list.search(eventName,"Event title"))
      System.out.println("Event not found");
    else
    {
      System.out.println("All contacts belonging to the event above: ")
      list.getContactList().findfirst();
      while(!list.getContactList().last())
      {
         System.out.println(list.getContactList().retrieve().toString());
         list.getContactList().fintNext();
      }
      System.out.println(list.getContactList().retrieve().toString());
    } 
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
