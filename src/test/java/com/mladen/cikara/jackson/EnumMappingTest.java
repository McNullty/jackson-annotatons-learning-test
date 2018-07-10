package com.mladen.cikara.jackson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class EnumMappingTest {

  @Test
  void testDeserializingCollectionWithEnums() throws JSONException, IOException {
    final Set<String> authorities = new HashSet<>();
    authorities.add(Authority.ROLE_ADMIN.toString());
    authorities.add(Authority.ROLE_USER.toString());

    final JSONArray array = new JSONArray(authorities);

    final JSONObject jsonObj =
        new JSONObject()
            .put("authorities", array);

    System.out.println(jsonObj.toString());
    final ObjectMapper mapper = new ObjectMapper();
    final CollectionAuthorityDto result = mapper.readerFor(CollectionAuthorityDto.class)
        .readValue(jsonObj.toString());

    final CollectionAuthorityDto dto = new CollectionAuthorityDto();

    final Set<Authority> authorities2 = new HashSet<>();
    authorities2.add(Authority.ROLE_ADMIN);
    authorities2.add(Authority.ROLE_USER);

    dto.setAuthorities(authorities2);

    assertEquals(dto, result);

    System.out.println(result);
  }

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
  void testSerializingCollectionWithEnums() throws JsonProcessingException {
    final CollectionAuthorityDto dto = new CollectionAuthorityDto();

    final Set<Authority> authorities = new HashSet<>();
    authorities.add(Authority.ROLE_ADMIN);
    authorities.add(Authority.ROLE_USER);

    dto.setAuthorities(authorities);

    final ObjectMapper mapper = new ObjectMapper();

    final String result = mapper.writeValueAsString(dto);

    assertEquals("{\"authorities\":[\"ROLE_USER\",\"ROLE_ADMIN\"]}", result);
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
