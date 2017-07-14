package com.report.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;

import com.report.mapping.SubscriptionRowMapper;

public class ResourceName implements Tasklet {
	private static Logger log = Logger.getLogger(ResourceName.class);
	private String resource;

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
		Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1); 
        Date date=cal.getTime();
		String formatedDate= sdf.format(date);
		this.resource = resource+formatedDate+".csv";
/*		ExecutionContext jobExecutionContext = chunkContext.getStepContext()
				.getStepExecution().getJobExecution().getExecutionContext();

		jobExecutionContext.put("FileName", resource); */
	}
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		String fileResource = resource.replace("file:", "");
		File file = new File(fileResource);
		if(file.exists())
		{
			log.debug("File previously exists, deleting the old file");
			file.delete();
		}
		ExecutionContext jobExecutionContext = chunkContext.getStepContext()
				.getStepExecution().getJobExecution().getExecutionContext();
		jobExecutionContext.put("FileName", resource); 
		return RepeatStatus.FINISHED;  
		
	}
	

}
