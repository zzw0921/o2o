package cn.azzhu.myo2o;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("cn.azzhu.myo2o.mapper")
@EnableTransactionManagement
@ImportResource(locations = {"classpath:kaptcha.xml"})
public class MyO2oApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyO2oApplication.class, args);
    }

}
