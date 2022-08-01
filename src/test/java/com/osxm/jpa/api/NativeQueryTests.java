/**  
* @Title: NativeQueryTests.java
* @Package com.osxm.jpa.api
* @Description: TODO
* @author XM
* @date 2022年8月1日 下午10:31:49
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.jpa.api;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.osxm.jpa.entity.Usr;
import com.osxm.jpa.vo.UsrVo;

public class NativeQueryTests {
	
	@SuppressWarnings("unchecked")
    //@Test
    public void oneField() {
        String persistenceUnitName = "jpaency_mysql";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager entityManager = entityManagerFactory.createEntityManager();  
        String sql = "SELECT NAME FROM USR";        
        List<String> list = entityManager.createNativeQuery(sql).getResultList();
        if(list!=null) {
            for(Object obj:list) {
                System.out.println(obj.toString());
            }
        }
    }
	
    //@Test
    public void oneFieldWrongTranfer() {
        String persistenceUnitName = "jpaency_mysql";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager entityManager = entityManagerFactory.createEntityManager();  
        String sql = "SELECT NAME FROM USR";        
        List<String> list = entityManager.createNativeQuery(sql,String.class).getResultList();
        if(list!=null) {
            for(Object obj:list) {
                System.out.println(obj.toString());
            }
        }
    }
    
    //@Test
    public void moreFieldByEntityClass() {
        String persistenceUnitName = "jpaency_mysql";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager entityManager = entityManagerFactory.createEntityManager();  
        String sql = "SELECT ID,NAME FROM USR";        
        List<Usr> list = entityManager.createNativeQuery(sql,Usr.class).getResultList();
        if(list!=null) {
            for(Usr usr:list) {
                System.out.println(usr.getName());
            }
        }
    }
    
    //@Test
    public void moreFieldByClass() {
        String persistenceUnitName = "jpaency_mysql";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager entityManager = entityManagerFactory.createEntityManager();  
        String sql = "SELECT ID,NAME FROM USR";        
        List<UsrVo> list = entityManager.createNativeQuery(sql,UsrVo.class).getResultList();
        if(list!=null) {
            for(UsrVo usr:list) {
                System.out.println(usr.getName());
            }
        }
    }
    
    //@Test
    public void moreFieldByResultMapping() {
        String persistenceUnitName = "jpaency_mysql";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager entityManager = entityManagerFactory.createEntityManager();  
        String sql = "SELECT ID,NAME FROM USR";        
        List<Usr> list = entityManager.createNativeQuery(sql,"UsrResults").getResultList();
        if(list!=null) {
            for(Usr usr:list) {
                System.out.println(usr.getName());
            }
        }
    }
    
    @Test
    public void moreField() {
        String persistenceUnitName = "jpaency_mysql";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager entityManager = entityManagerFactory.createEntityManager();  
        String sql = "SELECT ID,NAME FROM USR";        
        List list = entityManager.createNativeQuery(sql).getResultList();
        if(list!=null) {
            if(list!=null&&list.size()>0) {
                for(int i=0;i<list.size();i++) {
                    Object row = list.get(i);
                    Object[] cells = (Object[])row;
                    System.out.println(cells[1].toString());
                }
            }
        }
    }
}
