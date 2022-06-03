/**  
* @Title: QueryTests.java
* @Package com.osxm.jpa.basic
* @Description: TODO
* @author XM
* @date 2022年6月3日 上午8:53:58
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.jpa.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.osxm.jpa.entity.Usr;

public class QueryTests {

	@Test
	public void find() {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaency_mysql");
		EntityManager em = emFactory.createEntityManager();
		Usr usr = em.find(Usr.class, 1);
		Assertions.assertEquals("刘备",usr.getName());
		em.close();
		emFactory.close();
	}
}
