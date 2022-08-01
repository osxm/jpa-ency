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

    private Long id;
    
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}