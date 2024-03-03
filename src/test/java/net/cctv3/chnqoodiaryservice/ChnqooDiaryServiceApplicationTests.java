package net.cctv3.chnqoodiaryservice;

import net.cctv3.chnqoodiaryservice.constants.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
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
        System.out.println(DigestUtils.md5Hex("Chnqoo@t:" + "1709445093427"));
        for (int i=0;i<100;i++) {
            System.out.println(StringUtils.buildRandomNumbers(7));
        }
    }
}
