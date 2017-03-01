package com.asiainfo.integration.o2p.task;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartTestBean implements Job{

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		while(true) {
			try {
				System.out.println(Thread.currentThread().getName() + " is alive!");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
