package com.mladen.cikara.jackson;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("authority")
public class SingleAuthorityDto {

  private Authority authority;

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final SingleAuthorityDto other = (SingleAuthorityDto) obj;
    if (authority != other.authority) {
      return false;
    }
    return true;
  }

  public Authority getAuthority() {
    return authority;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((authority == null) ? 0 : authority.hashCode());
    return result;
  }

  public void setAuthority(Authority authority) {
    this.authority = authority;
  }

  @Override
  public String toString() {
    return "SingleAuthorityDto [authority=" + authority + "]";
  }

}
