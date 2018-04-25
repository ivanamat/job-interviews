package es.ivanamat.springboot.jasper.service;

import es.ivanamat.springboot.jasper.bean.Car;
import java.util.List;

public interface ICarService {

    public List<Car> findAll();
}