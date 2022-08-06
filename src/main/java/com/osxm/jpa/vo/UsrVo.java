/**  
* @Title: UsrVo.java
* @Package com.osxm.jpa.vo
* @Description: TODO
* @author XM
* @date 2022年8月1日 下午10:42:21
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.jpa.vo;

public class UsrVo {

	private int id;

	private String name;

	public UsrVo(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}