import bada.*;
import org.junit.jupiter.api.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


public class CourtsDAOTest {

    private CourtsDAO dao;

    @BeforeEach
    public void Setup() throws Exception {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf");
        datasource.setUsername("jstempko");
        datasource.setPassword("jstempko");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new CourtsDAO(new JdbcTemplate(datasource));
    }

    @Test
    public void testList() {
        List<Court> courtList = dao.get();
        assertFalse(courtList.isEmpty());
    }

    @Test
    public void testSave() {
        Court court = new Court(0, "test name", "test address", 8, 20);
        dao.save(court);
    }

    @Test
    public void testGet() {
        int id = 2;
        Court court = dao.get(id);
        assertNotNull(court);
    }

    @Test
    public void testUpdate() {
        Court court = new Court();
        court.setId(2);
        court.setName("test updated");
        court.setAddress("test updated");
        court.setOpeningHour(0);
        court.setClosingHour(24);
    }

    @Test
    public void testDelete() {
        int id = 2;
        dao.delete(2);
    }
}