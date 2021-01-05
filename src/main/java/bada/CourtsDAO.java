package bada;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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


    public void save() {

    }

    public Court get(int id) {
        return list().get(id);
    }

    public void update(Sale sale) {

    }

    public void delete(int id) {

    }

}