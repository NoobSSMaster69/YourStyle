package org.example.config;

import jakarta.servlet.ServletRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.Filter;
import jakarta.servlet.MultipartConfigElement;



public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("C:\\Users\\Timur\\Desktop\\JavaPrograms\\YourStyle\\target\\YourStyle\\META-INF\\tmp"));
    }

    @Override
        protected Class<?>[] getRootConfigClasses() {
            return null;
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class[]{SpringConfig.class, JdbcConfiguration.class, WebSecurityConfig.class};
        }

        @Override
        protected String[] getServletMappings() {
            return new String[]{"/"};
        }

        @Override
        protected Filter[] getServletFilters(){
            CharacterEncodingFilter filter = new CharacterEncodingFilter();
            filter.setEncoding("UTF-8");
            filter.setForceEncoding(true);
             return new Filter[]{filter};
        }

//        private MultipartConfigElement getMultipartConfigElement(){
//            return new MultipartConfigElement(LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
//         }
    }
