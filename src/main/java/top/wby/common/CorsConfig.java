package top.wby.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 对所有请求路径生效
                .allowedOrigins("http://localhost:5173") // 允许的前端域名/端口
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的方法
                .allowCredentials(true) // 是否允许携带 cookie
                .maxAge(3600); // 预检请求的缓存时间
    }
}
