import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;

class BookOperation4{
public static void main(String args[]){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory factory=cfg.buildSessionFactory();

Session session=null;
Transaction t=null;
try{
session =factory.openSession();
System.out.println("Session Open");
t=session.beginTransaction();
Console c=System.console();
int bid=Integer.parseInt(c.readLine("Enter bid "));
Book b=(Book)session.get(Book.class, bid);
if(b!=null){
session.delete(b);
t.commit();
System.out.println("Record Deleted ");
}
else{
System.out.println("Book Does not exist");
}

}
catch(Exception e){
System.out.println("Issue "+e);
t.rollback();
}
finally{
session.close();
System.out.println("Session Close ");
}
}
}