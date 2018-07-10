package com.mladen.cikara.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.HashMap;
import java.util.Map;

public enum Authority {
  ROLE_ADMIN, ROLE_SYS_ADMIN, ROLE_USER;

  private static Map<String, Authority> namesMap = new HashMap<>();

  static {
    namesMap.put("ROLE_ADMIN", ROLE_ADMIN);
    namesMap.put("ROLE_SYS_ADMIN", ROLE_SYS_ADMIN);
    namesMap.put("ROLE_USER", ROLE_USER);
  }

  @JsonCreator
  public static Authority forValue(String value) {
    return namesMap.get(value.toUpperCase());
  }

}
