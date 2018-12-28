package top.ourlostyouth.www;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//@MapperScan("top.ourlostyouth.www.dao")
public class application {
    public static void main(String[] args) {
        SpringApplication.run(application.class, args);
    }


    //解决跨域问题
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        // 允许跨域
        config.setAllowCredentials(true);
        // 允许向该服务器提交请求的URI,*表示全部
        config.addAllowedOrigin("http://localhost:8080");
        // 允许访问的头信息,*表示全部
        config.addAllowedHeader("*");
        // 允许的method
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        // 免检时间,单位是秒
        // config.setMaxAge(3600)
        // Enabling CORS for the whole application
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}


