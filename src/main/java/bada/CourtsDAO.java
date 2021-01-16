package bada;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourtsDAO {

    private JdbcTemplate jdbcTemplate;

    public CourtsDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    // get court list
    public List<Court> get(){
        String sql = "SELECT * FROM Courts";
        List<Court> courts = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Court.class));
        return courts;
    }

    // get court by id
    public Court get(int id) {
        String sql = "SELECT * FROM Courts WHERE Id = " + id;
        Court court = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Court.class));
        return court;
    }

    // add new court
    public void save(Court court) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("courts").usingColumns("name", "address", "image", "opening_hour", "closing_hour");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(court);
        insertActor.execute(param);
    }

    // modify existing court
    public void update(Court court) {
        String sql = "UPDATE Courts SET name=:name, address=:address, image=:image, opening_hour=:openingHour, closing_hour=:closingHour WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(court);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    // delete a court
    public void delete(int id) {
        String sql = "DELETE FROM Courts WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}