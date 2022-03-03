package com.cvs.notification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class NotificationClient {

    @Value("${api.url}")
    private String API_URL;
	
    private RestTemplate restTemplate;
    
	public String sendNotification(List<NotificationRequest> payload) {

		restTemplate = new RestTemplate();
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString("https://cvs-notification-service-dev.wnp.polaris.cvshealthcloud.com/sendNotification");
		HttpHeaders headers = new HttpHeaders();
		headers.add("idToken", "");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<List<NotificationRequest>> entity = new HttpEntity<List<NotificationRequest>>(payload, headers);
		try {
			String str = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.POST, entity, String.class).toString();
			System.out.println(str);
			if(!str.isEmpty()) return "success" ;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return "failed";
		
	}
	
	public NotificationRequest buildRequest(String emailId, String subject) {
		NotificationRequest request = new NotificationRequest();	
		request.setBccAddresses(new ArrayList<String>());
		request.setCcAddresses(new ArrayList<String>());
		request.setFiles(new ArrayList<>());
		request.setSubject(subject);
		request.setToAddress(emailId);
		request.setFromAddress(emailId);
		request.setTemplate("VGhpcyBpcyBhIHJlbWluZGVyIGZyb20gQ1ZTIE1hcnQgYXQgQmx1ZSBBdmUuIFlvdSBoYXZlIHByZXNjcmlwdGlvbnMgcmVhZHkgZm9yIHBpY2t1cC4gUXVlc3Rpb25zPyBQbGVhc2UgY2FsbCB1cyBhdCAoOTk5KSA5OTktOTk5OS4=");
	//	TemplateVariables templateVariables = new TemplateVariables();
		//request.setTemplateVariables(templateVariables);
		return request;
	}
	
	public String  callNotification(String emailId, String subject) {
		
		NotificationRequest request = buildRequest(emailId,subject);
		List<NotificationRequest> list = new ArrayList<NotificationRequest>();
		list.add(request);
		return sendNotification(list);
		
	}
	
	public static void main(String [] args) {
		
		NotificationClient client  = new NotificationClient();
		client.callNotification("jaya.kumar@cvshealth.com", "refill prescription");
	}
}
