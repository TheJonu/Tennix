package bada.dao;

import bada.model.Court;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourtsDao {

    private JdbcTemplate jdbcTemplate;

    public CourtsDao(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Court> get(){
        String sql = "SELECT * FROM Courts";
        List<Court> courts = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Court.class));
        return courts;
    }

    public Court get(int id) {
        String sql = "SELECT * FROM Courts WHERE Id = " + id;
        Court court = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Court.class));
        return court;
    }

    public void save(Court court) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("courts").usingColumns("name", "address", "opening_hour", "closing_hour", "photo");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(court);
        insertActor.execute(param);
    }

    public void update(Court court) {
        String sql = "UPDATE Courts SET name=:name, address=:address, opening_hour=:openingHour, closing_hour=:closingHour, photo=:photo WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(court);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM Courts WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}