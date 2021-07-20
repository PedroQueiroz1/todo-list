package br.com.thelist.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="TheBook-service")
public interface TheBookProxy {
	
//	private Long id;
//	private String justAMessage;


}
