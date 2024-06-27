package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.IpurchaseOrder;

@SpringBootApplication
public class SpringBootMailApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringBootMailApplication.class, args);
		IpurchaseOrder order=ctx.getBean("purchaseService",IpurchaseOrder.class);
		try {
			String msg=order.purchase(new String[] {"shirt","trouser","watch"},
					   new double[] {5000,6000,7000},
					   new String[] {"priyaammu2626@gmail.com","sreemattaparthi897@gmail.com","vallimattaparthi897@gmail.com"});
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext)ctx).close();
	}

}
