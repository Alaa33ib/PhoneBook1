public class Contact implements Comparable
{

  private String name, phone, email, address, birthday, notes;

  public Contact() //default constructor
  {
	 name = phone = email = address = birthday = notes = "";
  }

  public Contact(String name, String phone, String email, String address, String birthday, String notes)
  {
    this.name = name;
    this.phone = phone;
	 this.email = email;
	 this.address = address;
	 this.birthday = birthday;
	 this.notes = notes;
  }

  public String toString()
  {
	 return "Name: "+name+",  Phone: "+phone+",  Email: "+email+",  Address: "+address+",  Birthday: "+birthday+",  Notes: "+notes;
  }

  public int compareTo(Object s) 
  {  
    Contact str = (Contact)s;
    int firstLength = this.getName().length();  
    int secondLength = str.getName().length();  
    int minLength = Math.min(firstLength, secondLength);
    int i = 0;  
    while(i < minLength) 
    {  
     char ch1 = this.getName().charAt(i);  
     char ch2 = str.getName().charAt(i);  
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
  
  public String getName()
  {
	 return name;
  }

  public String getPhone()
  {
	 return phone;
  }

  public String getEmail()
  {
	 return email;
  }

  public String getAddress()
  {
	 return address;
  }

  public String getBirthday()
  {
	 return birthday;
  }
 
  public String getNotes()
  {
	return notes;
  }
  
}

  

