package com.asiainfo.integration.o2p.task.listener;

/**
 * 类名称 LogServerListener <br>
 * 日志服务器端监听器
 * <p>
 * @version 1.0
 * @author Administrator 2013-2-1
 * <hr>
 * 修改记录
 * <hr>
 * 1、修改人员:    修改时间:<br>       
 *    修改内容:
 * <hr>
 */
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.ServletContextEvent;
import org.springframework.web.context.ContextLoaderListener;
import com.asiainfo.foundation.log.Logger;
import com.mysql.jdbc.AbandonedConnectionCleanupThread;

public class TaskServerListener extends ContextLoaderListener {
	private  static final Logger log = Logger.getLog(TaskServerListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		Driver d = null;
		while (drivers.hasMoreElements()) {
			try {
				d = drivers.nextElement();
				DriverManager.deregisterDriver(d);
			} catch (SQLException ex) {
				log.info(ex.getMessage());
			}
		}
		try {
			AbandonedConnectionCleanupThread.shutdown();
		} catch (InterruptedException e) {
			log.info(e.getMessage());
		}

	}
}
