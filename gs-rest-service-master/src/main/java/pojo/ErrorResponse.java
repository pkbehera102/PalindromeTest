package pojo;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpStatus;

@XmlRootElement
public class ErrorResponse {
	private String errorMessage;
	private HttpStatus responseStatus;
	private String cause;
	
	public ErrorResponse() {}
	public ErrorResponse(String errorMessage,HttpStatus responseStatus,String cause)
	{
		this.errorMessage = errorMessage;
		this.responseStatus = responseStatus;
		this.cause = cause;
		
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public HttpStatus getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(HttpStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
}
