package guru.springframework.sbmjackson.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void test_serializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    public void test_deserializeToDto() throws JsonProcessingException {
        String jsonString = "{\"id\":\"38351e0b-37e2-4232-877a-2f36716ea197\",\"beerName\":\"Beer\",\"beerStyle\":\"ALE\",\"upc\":1234567890,\"price\":10.00,\"createdDate\":\"2020-04-06T14:31:51.99453+02:00\",\"lastUpdatedDate\":\"2020-04-06T14:31:51.9965277+02:00\"}";

        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);

        System.out.println(beerDto);
    }
}