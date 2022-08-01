/**  
* @Title: Usr.java
* @Package com.osxm.entity
* @Description: TODO
* @author XM
* @date 2022年6月3日 上午9:02:19
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name="UsrResults", 
entities={ 
    @EntityResult(entityClass=Usr.class, fields={
        @FieldResult(name="id", column="ID"),
        @FieldResult(name="name", column="NAME")})}
)
@Entity
public class Usr {
	
	@Id
	private Integer id;
	
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
