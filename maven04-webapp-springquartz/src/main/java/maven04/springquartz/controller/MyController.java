/*******************************************************************************
 * Project Key : CPPII
 * Create on 2017年12月8日 上午10:27:06
 * Copyright (c) 2017.炬火數位有限公司版權所有. 
 * 注意：本內容僅限於炬火數位內部傳閱，禁止外洩以及用於其他商業目的
 ******************************************************************************/
package maven04.springquartz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user xxx 2017年12月8日 上午10:27:06
 */
@Controller
public class MyController {

	@RequestMapping("login")
	private @ResponseBody String hello(@RequestParam(value = "name", required = false) String name) {
		return "Hello " + name;
	}

}
