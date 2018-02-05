package com.scg.util;

/**
* A simple mailing address. Does no validity checking for things like valid states or postal codes. Instances of 
* this class are immutable.
* @author Brian Stamm
*/

public final class Address{
  private final String streetNumber;
  private final String city;
  private StateCode state;
  private final String postalCode;
  
  /**
  * Construct an Address.
  * @param streetNumber - the street number.
  * @param city - the city.
  * @param state - the state.
  * @param postalCode - the postal code.
  */
  public Address(String streetNumber,String city,StateCode state,String postalCode){
    this.streetNumber = streetNumber;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
  }
  
  /**
  * Get the street number number for this address.
  * @return the street number.
  */
  public String getStreetNumber(){
    return streetNumber;
  }
  
  /**
  * Gets the city for this address.
  * @return the city.
  */
  public String getCity(){
    return city;
  }
  
  /**
  * Get the state for this address.
  * @return the state.
  */
  public StateCode getState(){
    return state;
  }
  
  /**
  * Gets the postal code for this address.
  * @return the postal code.
  */
  public String getPostalCode(){
    return postalCode;
  }
  
}
