package model;

import java.util.List;

public class DTO <T>{

	private int error;
	private String message;
	private List<T> objects;
	
	public DTO(int error, String message, List<T> objects) {
		this.error = error;
		this.message = message;
		this.objects = objects;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getObject() {
		return objects;
	}

	public void setObject(List<T> object) {
		this.objects = object;
	}
	
	
}
