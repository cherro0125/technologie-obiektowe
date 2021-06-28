package pl.psk.to.mmo.mmo_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class MmoMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmoMybatisApplication.class, args);
    }

}
