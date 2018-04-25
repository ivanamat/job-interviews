package net.cloudapi.jasper.service;

import net.cloudapi.jasper.bean.Car;
import java.util.List;

public interface ICarService {

    public List<Car> findAll();
}