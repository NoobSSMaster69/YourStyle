package org.example.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final String LOCATION = "C:/mytemp/";
    private static final long MAX_FILE_SIZE = 1024 * 1024 * 25;//25MB
    private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 30;//30MB
    private static final int FILE_SIZE_THRESHOLD = 0;

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
