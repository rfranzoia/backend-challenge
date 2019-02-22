package com.invillia.acme.endpoints;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import com.invillia.acme.dto.StoreDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StoreEndpointTest
{

    private final String localhost = "http://localhost:";

    @Value("${local.server.port}")
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();


    @Test
    public void testListStores() throws InterruptedException
    {

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString());

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.localhost + this.port + "/v1/stores/");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<StoreDTO[]> response = this.restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, StoreDTO[].class);
        
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        Thread.sleep(500L);

        StoreDTO[] stores = response.getBody();

        assertThat(stores.length).isEqualTo(3);

    }
    
}
