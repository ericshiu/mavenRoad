/*******************************************************************************
 * Project Key : CPPII
 * Create on 2017年10月24日 下午5:34:51
 * Copyright (c) 2017.炬火數位有限公司版權所有. 
 * 注意：本內容僅限於炬火數位內部傳閱，禁止外洩以及用於其他商業目的
 ******************************************************************************/
package com.test;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user xxx 2017年10月24日 下午5:34:51
 */
@ContextConfiguration(locations = { "classpath:/spring-default.xml" })
public class BaseTxTest extends AbstractJUnit4SpringContextTests {

	protected transient Logger log = LoggerFactory.getLogger(getClass());

	@Before
	public void setUp() {
	}

}
