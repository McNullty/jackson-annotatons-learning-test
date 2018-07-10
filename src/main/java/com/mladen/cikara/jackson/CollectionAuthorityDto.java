package com.mladen.cikara.jackson;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Set;

@JsonRootName("authorities")
public class CollectionAuthorityDto {

  private Set<Authority> authorities;

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
    final CollectionAuthorityDto other = (CollectionAuthorityDto) obj;
    if (authorities == null) {
      if (other.authorities != null) {
        return false;
      }
    } else if (!authorities.equals(other.authorities)) {
      return false;
    }
    return true;
  }

  public Set<Authority> getAuthorities() {
    return authorities;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((authorities == null) ? 0 : authorities.hashCode());
    return result;
  }

  public void setAuthorities(Set<Authority> authorities) {
    this.authorities = authorities;
  }

  @Override
  public String toString() {
    return "CollectionAuthorityDto [authorities=" + authorities + "]";
  }
}
