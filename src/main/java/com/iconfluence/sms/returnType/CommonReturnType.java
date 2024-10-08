package com.iconfluence.sms.returnType;

public class CommonReturnType {
  private String status;
  private Object data;

  public static CommonReturnType create(Object data) {
    return create("success", data);
  }

  public static CommonReturnType create(String status, Object data) {
    CommonReturnType commonReturnType = new CommonReturnType();
    commonReturnType.status = status;
    commonReturnType.data = data;
    return commonReturnType;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
