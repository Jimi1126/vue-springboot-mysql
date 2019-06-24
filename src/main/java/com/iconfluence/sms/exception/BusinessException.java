package com.iconfluence.sms.exception;

public class BusinessException extends Exception implements CommonException {

  private CommonException error;

  public BusinessException(CommonException error) {
    super();
    this.error = error;
  }

  public BusinessException(String message, CommonException error) {
    super();
    error.SetErrMsg(message);
    this.error = error;
  }

  @Override
  public String getErrCode() {
    return error.getErrCode();
  }

  @Override
  public String getErrMsg() {
    return error.getErrMsg();
  }

  @Override
  public CommonException SetErrMsg(String Msg) {
    error.SetErrMsg(Msg);
    return this;
  }
}
