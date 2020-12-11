package com.brainstation.employeesalary.common.exception;

import com.brainstation.employeesalary.common.BaseResponse;

public class ErrorResponse extends BaseResponse{
	
	
    private String error;
    private String exception;
    private String path;
    private Long instituteId;
    private int responseCode;
    
    
    public ErrorResponse(int responseCode, String error, String exception, String message, String path,Long instituteId) {
        this.error = error;
        this.exception = exception;
        super.message = message;
        this.path = path;
        this.instituteId=instituteId;
    }
    
    
    
    
    
	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}


	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Long getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(Long instituteId) {
		this.instituteId = instituteId;
	}
    
    
    
    

}
