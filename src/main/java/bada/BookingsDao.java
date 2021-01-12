package bada;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingsDao {

    private JdbcTemplate jdbcTemplate;

    public BookingsDao(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    // get a court's bookings
    public List<Booking> getByCourt(int id){
        String sql = "SELECT * FROM Bookings WHERE Court_id = " + id;
        List<Booking> bookings = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Booking.class));
        return bookings;
    }

    // add a new booking
    public void save(Booking booking) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("bookings").usingColumns("day", "hour", "court_id", "client_id", "employee_id");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(booking);
        insertActor.execute(param);
    }

}