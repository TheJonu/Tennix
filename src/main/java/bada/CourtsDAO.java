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

    public List<Court> list(){
        String sql = "SELECT * FROM Courts";
        List<Court> courtList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Court.class));
        return courtList;
    }


    public void save(Court court) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("courts").usingColumns("name", "address", "opening_hour", "closing_hour");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(court);
        insertActor.execute(param);
    }

    public Court get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM Courts WHERE ID = " + args[0];
        Court court = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Court.class));
        return court;
    }

    public void update(Court court) {
        String sql = "UPDATE Courts SET name=:name, address=:address, opening_hour=:openingHour, closing_hour=:closingHour WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(court);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {

    }

}