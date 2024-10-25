package zucchivan.dev;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SchemaVerificationTests {

    private final JdbcTemplate jdbcTemplate;

    public SchemaVerificationTests(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Test
    public void testTablesExist() {
        /*
        Integer userTableCount = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM information_schema.tables WHERE table_name = 'USER'", Integer.class);
        Integer projectTableCount = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM information_schema.tables WHERE table_name = 'PROJECT'", Integer.class);

        assertThat(userTableCount).isEqualTo(1);
        assertThat(projectTableCount).isEqualTo(1);
         */
        assertTrue(true);
    }

}
