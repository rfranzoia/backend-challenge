package com.invillia.acme.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class OrderItemRepositoryTest
{

    @Autowired
    private OrderItemRepository repository;
    
    @Test
    public void testOrderItemRepository() {
        
        assertThat(repository).isNotNull();
        
        long count = repository.count();
        
        assertThat(count).isGreaterThanOrEqualTo(0);
        
    }
}