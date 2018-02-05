package com.scg.util;

/**
* U. S. Postal state codes.
* @author Brian Stamm
*/
public enum StateCode{
  CA("CALIFORNIA"),
  WA("WASHINGTON");
  
  private String name;
  
  private StateCode(final String name){
    this.name = name;
  }
  
}
