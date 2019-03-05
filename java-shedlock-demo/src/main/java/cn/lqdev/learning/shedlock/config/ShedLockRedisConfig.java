package cn.lqdev.learning.shedlock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.redis.spring.RedisLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;

/** 
*
* @ClassName   类名：ShedLockRedisConfig 
* @Description 功能说明：redis配置
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
@Configuration
//defaultLockAtMostFor 指定在执行节点结束时应保留锁的默认时间使用ISO8601 Duration格式
//作用就是在被加锁的节点挂了时，无法释放锁，造成其他节点无法进行下一任务
//这里默认30s
//关于ISO8601 Duration格式用的不到，具体可上网查询下相关资料，应该就是一套规范，规定一些时间表达方式
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class ShedLockRedisConfig {
	
	//正常情况下 应该按实际环境来区分的
	//这里为了方便 写成test便于是测试
//	@Value("${spring.profiles.active}")
	String env = "test";
	
	@Bean
	public LockProvider lockProvider(RedisConnectionFactory connectionFactory) {
		//环境变量 -需要区分不同环境避免冲突，如dev环境和test环境，两者都部署时，只有一个实例进行，此时会造成相关环境未启动情况
	    return new RedisLockProvider(connectionFactory, env);
	}
}
