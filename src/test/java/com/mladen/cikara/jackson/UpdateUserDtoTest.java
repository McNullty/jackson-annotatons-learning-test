package com.mladen.cikara.jackson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class UpdateUserDtoTest {

  @Test
  void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
    final String json =
        "{\"user\":{\"firstName\":\"newFirstName\",\"lastName\":\"newLastName\"}}";

    final UpdateUserDto bean = new ObjectMapper()
        // .enable(SerializationFeature.WRAP_ROOT_VALUE)
        .enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
        .readerFor(UpdateUserDto.class)
        .readValue(json);

    assertEquals("newFirstName", bean.getFirstName());
  }

  @Test
  void whenSerializingUsingJsonRootName_thenCorrect() throws Exception {
    final UpdateUserDto user = new UpdateUserDto("firstName", "lastName");

    final ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    final String result = mapper.writeValueAsString(user);

    System.out.println(result);
  }

}
