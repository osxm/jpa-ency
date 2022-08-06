/**  
* @Title: JpaQueryPartFieldsTests.java
* @Package com.osxm.springbootency.jpa
* @Description: TODO
* @author XM
* @date 2022年8月6日 下午6:42:31
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.jpa.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.osxm.jpa.entity.Usr;
import com.osxm.jpa.vo.UsrVo;

public class JpaQueryPartFieldsTests {
private  static EntityManager entityManager;
    
    private static EntityManagerFactory entityManagerFactory;
    
    
    //@Test //不可行
    public void querySomeFields() {
        String hql = "select u.id,u.name from Usr u";
        List<Usr> list = entityManager.createQuery(hql,Usr.class).getResultList();
        System.out.println(list.get(0).getName());
    }
    
    //@Test  //不可行
    public void querySomeFieldsByModel() {
        String hql = "from Usr u";
        List<UsrVo> list = entityManager.createQuery(hql,UsrVo.class).getResultList();
        System.out.println(list.get(0).getName());
    }
    
    @Test  //正确姿势
    public void querySomeFieldsByModelRight() {
        String hql = "select new com.osxm.jpa.vo.UsrVo(u.id,u.name) from Usr u";
        List<UsrVo> list = entityManager.createQuery(hql,UsrVo.class).getResultList();
        System.out.println(list.get(0).getName());
        System.out.println(list.get(0).getId());
    }
    
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
}
