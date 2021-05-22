package org.zerock.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 해당 클래스의 인스턴스를 이용해서 설정 파일을 대신함
@Configuration
@ComponentScan(basePackages= {"org.zerock.sample"})
public class RootConfig {

}
