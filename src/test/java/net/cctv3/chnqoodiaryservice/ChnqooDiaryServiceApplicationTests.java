package net.cctv3.chnqoodiaryservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class ChnqooDiaryServiceApplicationTests {

    @Test
    void contextLoads() {
        testUUID();
    }

    private void testUUID() {
        for (int i=0;i<100;i++) {
            System.out.println(UUID.randomUUID());
        }
    }
}
