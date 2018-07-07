package com.mladen.cikara.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("user")
public class UpdateUserDto {

  private String firstName;
  private String lastName;

  @JsonCreator
  public UpdateUserDto(@JsonProperty("firstName") String firstName,
      @JsonProperty("lastName") String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "UpdateUserDto [firstName=" + firstName + ", lastName=" + lastName + "]";
  }
}
