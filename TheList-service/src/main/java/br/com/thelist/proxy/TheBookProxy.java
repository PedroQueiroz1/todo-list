package br.com.thelist.proxy;

import javax.persistence.Column;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="TheBook-service")
public interface TheBookProxy {
	
//	private Long id;
//	private String justAMessage;


}
