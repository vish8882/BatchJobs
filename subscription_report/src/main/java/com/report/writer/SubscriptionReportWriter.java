/**
 * 
 */
package com.report.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.report.domain.SubscriptionReporting;

/**
 * @author Swetha 
 * 
 *         Refund Report which replaces line feed/carriage return with
 *         empty strings
 */
public class SubscriptionReportWriter implements ItemWriter<SubscriptionReporting>,FlatFileHeaderCallback,ItemStream {
	private static Logger log = Logger.getLogger(SubscriptionReportWriter.class);
//	private static final String LINE_SEPARATOR = "\r\n|\n|;";

	
	/*@Override
	public void write(List<? extends RefundReporting> listOfItems) throws Exception {
		RefundReporting item=listOfItems.get(0);
		if (item.getZipcode() != null) {
			item.setZipcode(Integer.parseInt((String.valueOf(item.getZipcode()).replaceAll(LINE_SEPARATOR, ""))));
		}
		if (item.getType() != null) {
			item.setType(item.getType().replaceAll(LINE_SEPARATOR, ""));
		}
		if (item.getProviderId()!= null) {
			item.setProviderId(item.getProviderId().replaceAll(LINE_SEPARATOR, ""));
		}
		if (item.getResourceId() != null) {
			item.setResourceId(item.getResourceId().replaceAll(LINE_SEPARATOR, ""));
		}
		if (item.getTitle() != null) {
			item.setTitle(item.getTitle().replaceAll(LINE_SEPARATOR, ""));
		}
		if (item.getRefundPrice() != 0.0) {
			item.setRefundPrice(Float.parseFloat(((String.valueOf(item.getZipcode()).replaceAll(LINE_SEPARATOR, "")))));
		}
		if (item.getReason() != null) {
			item.setReason(item.getReason().replaceAll(LINE_SEPARATOR, ""));
		}
		if (item.getRefundDate()!= null) {
			Date d1= (Date)item.getRefundDate();
			DateFormat df= new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			String str = df.format(d1);
			item.setRefundDate(new Date(str.replaceAll(LINE_SEPARATOR, "")));
		}
		if (item.getWhoAuthorized() != null) {
			item.setWhoAuthorized(item.getWhoAuthorized().replaceAll(LINE_SEPARATOR, ""));
		}
		
	}*/

	private FlatFileItemWriter<SubscriptionReporting> delegate;
	private String headerString;
	public FlatFileItemWriter<SubscriptionReporting> getDelegate() {
		return delegate;
	}
	public void setDelegate(final FlatFileItemWriter<SubscriptionReporting> delegate) {
		this.delegate = delegate;
	}
	@Override
	public void open(ExecutionContext executionContext)throws ItemStreamException {
		this.delegate.open(executionContext);
	}
	
	@Override
	public void update(ExecutionContext executionContext)
			throws ItemStreamException {
		this.delegate.update(executionContext);

	}

	@Override
	public void close() throws ItemStreamException {
		this.delegate.close();

	}
	@Override
	public void write(List<? extends SubscriptionReporting> items) throws Exception {
		log.debug("Writing contents in file");
		this.delegate.write(items);
	}
	
	@Override
	public void writeHeader(Writer writer) throws IOException {
		writer.write(headerString);

	}
	
	public String getHeaderString() {
		return headerString;
	}

	public void setHeaderString(String headerString) {
		this.headerString = headerString;
	}
	
}
