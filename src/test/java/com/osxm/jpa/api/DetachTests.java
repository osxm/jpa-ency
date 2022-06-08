/**  
* @Title: DetachTests.java
* @Package com.osxm.jpa.api
* @Description: TODO
* @author XM
* @date 2022年6月6日 下午10:14:48
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.jpa.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.osxm.jpa.entity.Usr;

public class DetachTests {
	
	@Test
	public void detach() {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaency_mysql");
		EntityManager entityManager = emFactory.createEntityManager();
		Usr usr = entityManager.find(Usr.class, 1);
		entityManager.getTransaction().begin();
		//entityManager.detach(usr); //分离对象
		//Assertions.assertFalse(entityManager.contains(usr));//对象不包含在实体管理器中
		usr.setName("刘备"); //对象值更新不会同步到数据库
        entityManager.getTransaction().commit();
        entityManager.close();
		emFactory.close();
	}
}
