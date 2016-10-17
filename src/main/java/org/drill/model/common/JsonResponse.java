package org.drill.model.common;

public class JsonResponse<T> {
	private T data;
	private int code;
	private String message;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JsonResponse [data=" + data + ", code=" + code + ", message=" + message + "]";
	}

}
