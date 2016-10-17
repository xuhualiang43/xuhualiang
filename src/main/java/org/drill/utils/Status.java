package org.drill.utils;

public enum Status{
	
	QUERY_SUCCESS("查询成功",1001),
	
	QUERY_FAILD("请求参数错误",1002);
	
	
	private String codeDesc;
	private int code;
	
	private Status(String codeDesc, int code) {
		this.codeDesc = codeDesc;
		this.code = code;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
	
}
