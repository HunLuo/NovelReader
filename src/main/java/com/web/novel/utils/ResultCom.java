package com.book.utils;
/**
 * Desc  返回信息bean
 * @author :anlei
 * @date : 2017年8月9日 下午3:44:34
 */
public class ResultCom {
	/**
	 * 返回状态码
	 */
	private String code;
	/**
	 * 返回页面提示信息
	 */
	private String message;
	/**
	 * 备注
	 */
	private String remark;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public static ResultCom getOkResult(){
		if (resultCom!=null) {
			return resultCom;
		}
		return resultCom=new ResultCom("0", "保存成功!文件路径为默认下载路径..", "ok");
	}
	
	private static ResultCom resultCom;
	
	public ResultCom(String code, String message, String remark) {
		super();
		this.code = code;
		this.message = message;
		this.remark = remark;
	}
	public ResultCom() {
		super();
	}
}
