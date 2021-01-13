package bada;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientsDao {

    private JdbcTemplate jdbcTemplate;

    public ClientsDao(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    // get court list
    public List<Client> get(){
        String sql = "SELECT * FROM Clients";
        List<Client> clients = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Client.class));
        return clients;
    }

    // get court by id
    public Client get(int id) {
        String sql = "SELECT * FROM Clients WHERE Id = " + id;
        Client client = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Client.class));
        return client;
    }

    // add new court
    public void save(Client client) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("clients").usingColumns("id", "login", "name", "registration_date");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(client);
        insertActor.execute(param);
    }

    // modify existing court
    public void update(Client client) {
        String sql = "UPDATE Clients SET login=:login, name=:name WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(client);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    // delete a court
    public void delete(int id) {
        String sql = "DELETE FROM Clients WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}