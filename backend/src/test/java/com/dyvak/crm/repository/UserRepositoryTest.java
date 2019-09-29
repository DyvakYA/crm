package com.dyvak.crm.repository;

import com.dyvak.crm.domain.User;
import com.dyvak.crm.security.UserRole;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    public static final Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository users;

    private User dyvakYurii = User.builder()
            .email("dyvakyurii@gmail.com")
            .password("password")
            .role(UserRole.USER)
            .build();

    @Before
    public void fillSomeDataIntoOurDb() {
        // Add new Users to Database
        entityManager.persist(dyvakYurii);

    }

    @Test
    public void testFindByEmail() {
        // Search for specific User in Database according to notification
        Optional<User> usersEmailDyvakYurii = users.findByEmail("dyvakyurii@gmail.com");
        assertTrue(usersEmailDyvakYurii.isPresent());
    }

}