package cn.lqdev.learning.shedlock.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/** 
*
* @ClassName   类名：TaskConfigController 
* @Description 功能说明：
* <p>
* TODO
*</p>
************************************************************************
* @date        创建日期：2019年3月5日
* @author      创建人：oKong
* @version     版本号：V1.0
*<p>
***************************修订记录*************************************
* 
*   2019年3月5日   oKong   创建该类功能。
*
***********************************************************************
*</p>
*/
@RestController
@RequestMapping("/api")
@Slf4j
public class TaskConfigController {
	
	//区分服务
	@Value("${server.port}")
	String port;
	
	@RequestMapping("/task")
	public String execTask(){
		log.info("端口({})执行任务：{}", port, new Date());
		return "ok";
	}

}
