import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

class BookOperation2{
public static void main(String args[]){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory factory=cfg.buildSessionFactory();

Session session=null;

try{
session=factory.openSession();
System.out.println("Session Open");
List<Book> b=new ArrayList<>();
b=session.createQuery("from Book").list();
for(Book m:b)
System.out.println(m.getBid() +" "+m.getTitle());
}//end of try
catch(Exception e)
{
System.out.println("Issue "+e);
}//end of catch
finally{
session.close();
System.out.println("Session Close");
}//end of finally
}//end of main
}//end of class
