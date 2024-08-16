package com.nikhil.App;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nikhil.model.userinfo;

public class LaunchUpdate {

	public static void main(String[] args) 
	{
//		Configuration config=new Configuration();
//		config.configure();
//		config.addAnnotatedClass(userinfo.class);
//		SessionFactory sessionfactory=config.buildSessionFactory();
		SessionFactory sessionfactory = new Configuration().configure().addAnnotatedClass(userinfo.class).buildSessionFactory();
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try
		{
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			userinfo user=new userinfo();
			user.setUid(6);
			user.setUname("Sohit");
			user.setUcity("Ratanpur");
			
//			session.update(user);//deprecated
//			session.saveOrUpdate(user);//deprecated
			session.merge(user);
			flag=true;
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(flag==true)
			{
				transaction.commit();
			}
			else
			{
				transaction.rollback();
			}
			session.close();
			sessionfactory.close();
		}
		
		
	}

}
