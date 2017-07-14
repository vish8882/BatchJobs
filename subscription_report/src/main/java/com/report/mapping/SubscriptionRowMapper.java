package com.report.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.report.domain.SubscriptionReporting;
import com.report.util.DateUtil;


/**
 * 
 * @author vishal.v.kumar
 * 
 * AVS 4.2 This class maps the database fields to the Epg object
 * 
 */
public class SubscriptionRowMapper implements RowMapper<SubscriptionReporting> {
	private static Logger log = Logger.getLogger(SubscriptionRowMapper.class);

	@Override
	public SubscriptionReporting mapRow(ResultSet rs, int rownum) throws SQLException {
		int i=1; 
		SubscriptionReporting subscriptionReport = new SubscriptionReporting();
		subscriptionReport.setId(i++);
			subscriptionReport.setTenantId("tenantDefault");
		try{
		subscriptionReport.setProviderName(rs.getString("content_provider"));
		}
		catch(Exception e)
		{
			subscriptionReport.setProviderName("");
		}
		subscriptionReport.setServiceName(rs.getString("solution_offer_name"));
		subscriptionReport.setUserId(rs.getString("user_id"));
		subscriptionReport.setNowDateString(DateUtil.getDateInFormat(new Date()));
		subscriptionReport.setPlatform(rs.getString("purchase_channel"));
		try{
		subscriptionReport.setContentId(rs.getString("content_id"));
		}
		catch(Exception e)
		{
			subscriptionReport.setContentId("");
		}
		subscriptionReport.setSolutionOfferId(rs.getString("item_id"));
		subscriptionReport.setSubscriptionId(rs.getString("sequence_id"));
		subscriptionReport.setState(rs.getString("status_name"));
		subscriptionReport.setSubscription_Activation_Date(DateUtil.getDateInFormat(rs.getTimestamp("start_date")));
		if(rs.getTimestamp("end_date")!=null)
			subscriptionReport.setSubscription_Deactivation_Date(DateUtil.getDateInFormat(rs.getTimestamp("end_date")));
		else
			subscriptionReport.setSubscription_Deactivation_Date(" ");
		subscriptionReport.setContentType(rs.getString("SOLUTION_OFFER_TYPE"));

		return subscriptionReport;	
	}
		
}
