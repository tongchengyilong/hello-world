package com.baiwang.custom.web.interceptor;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created on 2017-5-23
 * <p>Description: [自定义拦截器——IP地址过滤]</p>
*/
public class IPAddressInterceptor extends AbstractPhaseInterceptor<Message> {

	private WSInterceptor iWSInterceptor;

	private static final Logger iLogger = LoggerFactory.getLogger(IPAddressInterceptor.class);

	public IPAddressInterceptor(WSInterceptor wsInterceptor)
	{
		super(Phase.RECEIVE);
        iWSInterceptor = wsInterceptor;
	}

	public void handleMessage(Message message) throws Fault
	{
		HttpServletRequest request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);

		//取客户端IP地址
		String accessIP = request.getRemoteAddr();

        //从文件或数据库中读取预先设置的允许和拒绝地址列表
        List<String> deniedIPList = iWSInterceptor.getDeniedIPList();
        List<String> allowedIPList = iWSInterceptor.getAllowedIPList();

		iLogger.info("WSInterceptor—IP " + accessIP + " WILL BE CHECKED");

		// 先处理拒绝访问的地址
		if (deniedIPList != null && !deniedIPList.isEmpty())
		{
			for (String deniedIPAddress : deniedIPList)
			{
				if (accessIP.equals(deniedIPAddress))
				{
					throw new Fault(new IllegalAccessException("IP address " + accessIP + " is denied"));
				}
			}
		}
		else
		{
			iLogger.info("WSInterceptor—Denied IP list is not configured, All IP is accessible");
		}

		// 如果允许访问的集合非空，继续处理，否则认为全部IP地址均合法  
		if (allowedIPList != null && !allowedIPList.isEmpty())
		{
			boolean contains = false;
			for (String allowedIPAddress : allowedIPList)
			{
				if (accessIP.equals(allowedIPAddress))
				{
					contains = true;
					break;
				}
			}
			if (!contains)
			{
				throw new Fault(new IllegalAccessException("IP address " + accessIP + " is not allowed"));
			}
		}
		else
		{
			iLogger.info("WSInterceptor—Allowed IP list is not configured, All IP is accessible");
		}
	}
}