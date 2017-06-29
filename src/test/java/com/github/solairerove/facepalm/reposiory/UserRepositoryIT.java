package com.github.solairerove.facepalm.reposiory;

import com.github.solairerove.facepalm.security.model.Authority;
import com.github.solairerove.facepalm.security.model.AuthorityName;
import com.github.solairerove.facepalm.security.model.User;
import com.github.solairerove.facepalm.security.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryIT {

    @Autowired
    private UserRepository repository;

    private User user;

    @Before
    public void setUp() {
        final Authority authority = new Authority();
        authority.setName(AuthorityName.ROLE_ADMIN);
        final List<Authority> authorities = Collections.singletonList(authority);

        user = new User();
        user.setUsername("solairerove");
        user.setPassword("some_difficult_pass");
        user.setFirstName("mikita");
        user.setLastName("krivitski");
        user.setEmail("solairerove@gmail.com");
        user.setAuthorities(authorities);

        repository.save(user);
    }

    @Test
    public void findByUsernameTest() {
        final User result = repository.findByUsername(user.getUsername());

        assertThat(result.getUsername(), is(user.getUsername()));
    }
}
