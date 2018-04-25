package es.ivanamat.springboot.jasper.service;

import es.ivanamat.springboot.jasper.bean.Car;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CarService implements ICarService {

    @Autowired
    private JdbcTemplate jtm;

    @Override
    public List<Car> findAll() {
        String sql = "SELECT * FROM Cars";
        List<Car> cars = jtm.query(sql, new BeanPropertyRowMapper<Car>(Car.class));
        return cars;
    }
}