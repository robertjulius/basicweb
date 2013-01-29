package com.cjs;

import org.hibernate.Session;

import com.cjs.basicweb.base.HibernateUtil;

public class TestHibernate 
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
    }
}