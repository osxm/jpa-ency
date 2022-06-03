/**  
* @Title: JUnit5Tests.java
* @Package com.osxm.jpa.junit
* @Description: TODO
* @author XM
* @date 2022年6月1日 上午7:17:29
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.jpa.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JUnit5Tests {

	@Test
	public void hello() {
		Assertions.assertTrue(1>0);
	}
}
