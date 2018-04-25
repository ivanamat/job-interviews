package es.ivanamat.springboot.jasper.controller;

import es.ivanamat.springboot.jasper.service.ICarService;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

@Controller
public class MyController {
	
    @Autowired
    private DataSource dataSource;

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private ICarService carService;
    
    @RequestMapping(path = "/report.pdf", method = RequestMethod.GET)
    public ModelAndView report() throws ClassNotFoundException {
        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:templates/report.jrxml");
        view.setApplicationContext(appContext);
        view.setJdbcDataSource(dataSource);

        System.out.println(carService.findAll().toString());
        
        Map<String, Object> params = new HashMap<>();
        params.put("Cars", carService.findAll());
        return new ModelAndView(view, params);
    }
}