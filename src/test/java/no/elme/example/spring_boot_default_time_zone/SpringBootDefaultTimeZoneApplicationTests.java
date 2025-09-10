package no.elme.example.spring_boot_default_time_zone;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.TimeZone;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringBootDefaultTimeZoneApplicationTests {

    @Test
    void whenChangingTheDefaultTimeZoneDuringStartup_expectTimeZoneToBeTheSouthPoleAntarctica() {
        TimeZone defaultTimeZone = TimeZone.getDefault();

        assertThat(defaultTimeZone.getID()).isEqualTo("Antarctica/South_Pole");
    }

}
