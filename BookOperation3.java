import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;

class BookOperation3{
public static void main(String args[]){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory factory=cfg.buildSessionFactory();

Session session=null;
Transaction t=null;
try{
session=factory.openSession();
System.out.println("Session Open");
t=session.beginTransaction();
Console c=System.console();
int bid=Integer.parseInt(c.readLine("Enter bid "));
Book b=(Book)session.get(Book.class, bid);
if(b!=null){
String title=c.readLine("Enter new Title ");
b.setTitle(title);
session.save(b);
t.commit();
System.out.println("Record updated");
}

else{

System.out.println("Book does not Exists ");
}
}//end of try

catch(Exception e){
System.out.println("Issue "+e);
t.rollback();
}//end of catch
finally{
session.close();
System.out.println("Session Closed ");
}//end of finally


}//end of main
}//end of class