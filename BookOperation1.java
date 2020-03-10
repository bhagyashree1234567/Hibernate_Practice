import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;

class BookOperation1{
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
int bid=Integer.parseInt(c.readLine("Enter Bid "));

String title=c.readLine("Enter Title");
Book b=new Book();
b.setBid(bid);
b.setTitle(title);
session.save(b);
t.commit();
System.out.println("Record Inserted");
}//end of try

catch(Exception e){
System.out.println("Issue "+e);
t.rollback();
}//end of catch
finally{
session.close();
System.out.println("Session Close");
}//end of finally

}//end of main

}//end of class