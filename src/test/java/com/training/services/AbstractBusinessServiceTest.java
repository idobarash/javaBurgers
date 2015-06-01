package com.training.services;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:daoTestApplicationContext.xml")
public abstract class AbstractBusinessServiceTest {

	@Resource
	private SessionFactory sessionFactory;
	
	private Transaction transaction = null;
	
	/**
	 * Open transaction and session.
	 */
	@Before
	public void openTransactionBeforeTest() {
		sessionFactory.openSession();
		transaction = sessionFactory.getCurrentSession().beginTransaction();
	}
	
	/**
	 * Close transaction and session.
	 */
	@After
	public void closeTransactionAfterTest() {
		transaction.rollback();
		//transaction.commit();
		transaction = null;
	}
}
