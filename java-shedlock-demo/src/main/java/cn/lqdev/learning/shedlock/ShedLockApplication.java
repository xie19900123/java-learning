package cn.lqdev.learning.shedlock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @ClassName 类名：ShedLockApplication
 * @Description 功能说明：启动类
 *              <p>
 *              TODO
 *              </p>
 ************************************************************************
 * @date 创建日期：2019年3月3日
 * @author 创建人：oKong
 * @version 版本号：V1.0
 *          <p>
 ***************************          修订记录*************************************
 * 
 *          2019年3月3日 oKong 创建该类功能。
 *
 ***********************************************************************
 *          </p>
 */
@SpringBootApplication
@EnableScheduling // 开启定时任务
@Slf4j
public class ShedLockApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ShedLockApplication.class, args);
		log.info("java-shedlock-demo启动!");
	}
}
