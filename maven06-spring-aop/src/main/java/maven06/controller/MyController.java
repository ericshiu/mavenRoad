/*******************************************************************************
 * Project Key : CPPII
 * Create on 2017年12月8日 上午10:27:06
 * Copyright (c) 2017.炬火數位有限公司版權所有. 
 * 注意：本內容僅限於炬火數位內部傳閱，禁止外洩以及用於其他商業目的
 ******************************************************************************/
package maven06.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import maven06.service.ControllerToService;

/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user xxx 2017年12月8日 上午10:27:06
 */
@Controller
public class MyController {
	@Autowired
	@Qualifier("ControllerToService")
	private ControllerToService controllerToService;

	@RequestMapping(value = "{productNo}", method = { RequestMethod.POST, RequestMethod.GET })
	private @ResponseBody String hello(@PathVariable("productNo") String productNo, HttpServletRequest request) {
		return (String) controllerToService.goService(productNo, null);
	}

}
