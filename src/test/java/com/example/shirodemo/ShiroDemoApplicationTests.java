package com.example.shirodemo;

import com.example.shirodemo.config.ProfileUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
class ShiroDemoApplicationTests {

    @Test
    void contextLoads() {
    }

}
