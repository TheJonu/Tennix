package bada;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalesDAO {

    private JdbcTemplate jdbcTemplate;

    public SalesDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Sale> list(){
        String sql = "SELECT * FROM Sales";
        List<Sale> listSale = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Sale.class));
        return listSale;
    }


    public void save() {

    }

    public Sale get(int id) {
        return list().get(id);
    }

    public void update(Sale sale) {

    }

    public void delete(int id) {

    }

}