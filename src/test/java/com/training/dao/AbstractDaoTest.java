package com.training.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.training.dao.base.GenericDao;


/**
 * Abstract test.
 * 
 * It initiates spring context for all tests in the DAO's layer
 * 
 * @param <T>	- The DAO type (for example: UserDao, OrderDao)
 * @param <E>	- The DAO's entity (for example: Uset, Order)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:daoTestApplicationContext.xml")
public abstract class AbstractDaoTest<T extends GenericDao<E>, E> {
	
	@Resource
	private SessionFactory sessionFactory;
	
	private Transaction transaction = null;
	
	
	
	/**
	 * Test the logics of create and read by Id
	 */
	public abstract void testCreateAndReadById();
	
	/**
	 * Test the logics of update an entity in the DB
	 */
	public abstract void testUpdate();
	
	/**
	 * Test the logics of deleting an entity in the DB
	 */
	public abstract void testDelete();
	
	
	
	
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
