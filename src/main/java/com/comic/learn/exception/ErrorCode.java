package com.comic.learn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public enum ErrorCode {
  COMIC_NOT_FOUND("DB_001", "Not found this comic", HttpStatus.NOT_FOUND),
  ORDER_NOT_FOUND("DB_002", "Not found this order", HttpStatus.NOT_FOUND),
  OUT_OF_STOCK("SV_001", "Stock is lower than quatity", HttpStatus.BAD_REQUEST),
  COMIC_IN_USE("SV_002", "Comic contains in a order", HttpStatus.BAD_REQUEST),
  ORDER_IS_NOT_PENDING("SV_003", "Order is not pending", HttpStatus.BAD_REQUEST),
  AMOUNT_IS_NOT_CONTAINS("SV_004", "Order is not equals total value", HttpStatus.BAD_REQUEST);

  String code;
  String information;
  HttpStatusCode statusCode;

  ErrorCode(String code, String information, HttpStatusCode statusCode) {
    this.code = code;
    this.information = information;
    this.statusCode = statusCode;
  }

  public String getCode() {
    return code;
  }

  public String getInformation() {
    return information;
  }

  public HttpStatusCode getStatusCode() {
    return statusCode;
  }
}
