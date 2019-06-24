package com.iconfluence.sms.exception;

public enum ErrorEnum implements CommonException{
  /**
   * 约定：
   * 0 开头为系统异常
   * 1 开头为业务逻辑异常
   */
  SYSTEM_ERROR("0001", "系统繁忙"),
  NOT_LOGIN_ERROR("1001", "用户未登陆"),
  PARAM_VERIFICATION_ERROR("1002", "参数不合法"),
  ;

  private String errCode;
  private String errMsg;

  ErrorEnum(String errCode, String errMsg) {
    this.errCode = errCode;
    this.errMsg = errMsg;
  }

  @Override
  public String getErrCode() {
    return errCode;
  }

  @Override
  public String getErrMsg() {
    return errMsg;
  }

  @Override
  public CommonException SetErrMsg(String Msg) {
    this.errMsg = Msg;
    return this;
  }
}
