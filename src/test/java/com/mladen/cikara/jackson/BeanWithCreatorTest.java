package com.mladen.cikara.jackson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class BeanWithCreatorTest {

  @Test
  void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
    final String json = "{\"id\":1,\"theName\":\"My bean\"}";

    final BeanWithCreator bean = new ObjectMapper()
        .readerFor(BeanWithCreator.class)
        .readValue(json);
    assertEquals("My bean", bean.name);
  }

}
