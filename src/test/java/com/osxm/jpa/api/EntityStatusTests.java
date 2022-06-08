/**  
* @Title: EntityStatusTests.java
* @Package com.osxm.jpa.api
* @Description: TODO
* @author XM
* @date 2022年6月8日 上午6:45:56
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.jpa.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.osxm.jpa.entity.Usr;

public class EntityStatusTests {

	private static EntityManagerFactory entityManagerFactory;
	
	private static EntityManager entityManager;
	
	@BeforeAll
	public static void setup() {
		String persistenceUnitName = "jpaency_mysql";
		 entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		 entityManager = entityManagerFactory.createEntityManager();		
	}
	
	
	@AfterAll
	public static void destroy() {
		entityManager.close();
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
	    }
	}
	
	
	@Test
	public void detachAfterCommit() {
		Usr usr = entityManager.find(Usr.class, 1);
	    boolean isManaged =  entityManager.contains(usr);
		Assertions.assertTrue(isManaged);		
		entityManager.getTransaction().begin();
		usr.setName("刘备3");
		entityManager.flush();
		entityManager.getTransaction().commit();
		//entityManager.clear();
		//entityManager.detach(usr);
		isManaged =  entityManager.contains(usr);
		Assertions.assertFalse(isManaged);
	}
	
}
