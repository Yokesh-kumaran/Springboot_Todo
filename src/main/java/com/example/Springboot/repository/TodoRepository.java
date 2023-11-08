package com.example.Springboot.repository;

import com.example.Springboot.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TodoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    class TodoRowMapper implements RowMapper<Todo> {
        public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Todo(rs.getInt("id"), rs.getString("item"));
        }
    }

    public List<Todo> findAllTodos() {
        return jdbcTemplate.query("SELECT * FROM todo;", new TodoRowMapper());
    }

    public Todo findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM todo WHERE id = ?;",
                new Object[]{id},
                new TodoRowMapper());
    }

    public List<Todo> insert(Todo todo) {
        jdbcTemplate.update("INSERT INTO todo (item) VALUES (?);",
                new Object[]{todo.getItem()});
        return findAllTodos();
    }

    public List<Todo> update(Todo todo){
        jdbcTemplate.update("UPDATE todo SET item = ? WHERE id = ?",
                new Object[]{todo.getItem(), todo.getId()});
        return findAllTodos();
    }

    public List<Todo> delete(int id){
        jdbcTemplate.update("DELETE FROM todo WHERE id = ?",
                new Object[]{id});
        return findAllTodos();
    }
}
