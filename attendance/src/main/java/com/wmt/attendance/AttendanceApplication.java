package com.wmt.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages={"com.wmt"})
public class AttendanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
	}
//	@Bean
//    public MapperScannerConfigurer mapperScannerConfigurer(){
//        
//        Properties properties=new Properties();
//        properties.put("mappers","tk.mybatis.mapper.common.Mapper,tk.mybatis.mapper.common.MySqlMapper");
//
//        MapperScannerConfigurer msc=new MapperScannerConfigurer();      
//        msc.getMapperHelper().setProperties(properties);
//        msc.setBasePackage("com.wmt");
//        
//        return msc;
//    }
}
