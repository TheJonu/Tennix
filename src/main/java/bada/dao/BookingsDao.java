package bada.dao;

import bada.model.Booking;
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

    public List<Booking> getByCourt(int id){
        String sql = "SELECT * FROM Bookings WHERE Court_id = " + id;
        List<Booking> bookings = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Booking.class));
        return bookings;
    }

    public List<Booking> getByClient(int id){
        String sql = "SELECT * FROM Bookings WHERE User_id = " + id;
        List<Booking> bookings = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Booking.class));
        return bookings;
    }

    public void save(Booking booking) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("bookings").usingColumns("day", "hour", "court_id", "user_id");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(booking);
        insertActor.execute(param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM Bookings WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}
