package com.offcn.controller;

import com.offcn.pojo.Car;
import com.offcn.pojo.Student;
import com.offcn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@EnableConfigurationProperties({User.class, Student.class})
public class HelloController {
    @Value("${picpath}")
    private String picpath;
    @Value("${port}")
    private String port;

    @Autowired
    private User user;

    @Autowired
    private Student student;

    /*@RequestMapping(value = "hello",method = RequestMethod.POST)*/
    @PostMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello SpringBoot!";
    }

    //返回一个car对象
    //@RequestMapping("findone")
    @GetMapping("findone")
    @ResponseBody
    public Car findOne(){
        Car car = new Car(1L, "法拉第", 1.99F, new Date());
        return car;
    }

    //@RequestMapping("findall")
    @PutMapping("finall")
    @ResponseBody
    public List<Car> findAll(){
        List<Car> list=new ArrayList<>();
        Car car1 = new Car(1L, "法拉第1", 1.99F, new Date());
        Car car2 = new Car(2L, "法拉第2", 1.99F, new Date());
        Car car3 = new Car(3L, "法拉第3", 1.99F, new Date());
        Car car4 = new Car(4L, "法拉第4", 1.99F, new Date());
        Car car5 = new Car(5L, "法拉第5", 1.99F, new Date());
        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(car4);
        list.add(car5);
        return list;
    }


    //读取自定义属性
   // @RequestMapping("demo3")
    @DeleteMapping("demo3")
    public String demo3(){
        return "picpath:"+picpath+" port:"+port;
    }

    //读取自定义类属性
    @RequestMapping("demo4")
    public String demo4(){
        return "id:"+user.getId()+" name:"+user.getName()+" address:"+user.getAddress();
    }

    @RequestMapping("demo5")
    public String demo5(){
        return "id:"+student.getId()+" name:"+student.getName()+" address:"+student.getAddress()+" age:"+student.getAge();
    }

}
