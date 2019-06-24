package com.iconfluence.sms.exception;

public interface CommonException{
  String getErrCode();
  String getErrMsg();
  CommonException SetErrMsg(String Msg);
}
