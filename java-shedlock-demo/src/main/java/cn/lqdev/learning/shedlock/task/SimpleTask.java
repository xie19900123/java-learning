package cn.lqdev.learning.shedlock.task;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.SchedulerLock;

/** 
*
* @ClassName   类名：SimpleTask 
* @Description 功能说明：
* <p>
* TODO
*</p>
************************************************************************
* @date        创建日期：2019年3月3日
* @author      创建人：oKong
* @version     版本号：V1.0
*<p>
***************************修订记录*************************************
* 
*   2019年3月3日   oKong   创建该类功能。
*
***********************************************************************
*</p>
*/
//@Component
@Slf4j
public class SimpleTask {
	
	//区分服务
	@Value("${server.port}")
	String port;
	
	//为了方便测试 设置cron表达式 
	@Scheduled(cron = "*/5 * * * * ?")
	//lockAtLeastFor：保证在设置的期间类不执行多次任务，单位是毫秒，此处可以根据实际任务运行情况进行设置，
	//简单来说，一个每15分钟执行的任务，若每次任务执行的时间为几分钟，则可以设置lockAtLeastFor大于其最大估计最大执行时间
	//避免一次任务未执行完，下一个定时任务又启动了。
	//任务执行完，会自动释放锁。
	@SchedulerLock(name="simpleTask",lockAtLeastFor = 1*1000)
	public void getCurrentDate() {
        log.info("端口({}),Scheduled定时任务执行：{}", port, new Date());
    }
}
