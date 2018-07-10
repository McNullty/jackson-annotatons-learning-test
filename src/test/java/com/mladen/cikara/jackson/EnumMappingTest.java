package com.mladen.cikara.jackson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

public class EnumMappingTest {

  @Test
  void testDeserializingDtoWithEnum() throws Exception {
    final String json = "{\"authority\":\"ROLE_ADMIN\"}";

    final ObjectMapper mapper = new ObjectMapper();

    final SingleAuthorityDto result = mapper.readerFor(SingleAuthorityDto.class)
        .readValue(json);

    final SingleAuthorityDto dto = new SingleAuthorityDto();
    dto.setAuthority(Authority.ROLE_ADMIN);
    assertEquals(dto, result);

    System.out.println(result);
  }

  @Test
  void testSerializingDtoWithEnum() throws JsonProcessingException {
    final SingleAuthorityDto dto = new SingleAuthorityDto();
    dto.setAuthority(Authority.ROLE_ADMIN);

    final ObjectMapper mapper = new ObjectMapper();

    final String result = mapper.writeValueAsString(dto);

    assertEquals("{\"authority\":\"ROLE_ADMIN\"}", result);
    System.out.println(result);
  }

  @Test
  void testSerializingEnum() throws Exception {
    final Authority authority = Authority.ROLE_ADMIN;

    final ObjectMapper mapper = new ObjectMapper();

    final String result = mapper.writeValueAsString(authority);

    assertEquals("\"ROLE_ADMIN\"", result);
    System.out.println(result);
  }
}
