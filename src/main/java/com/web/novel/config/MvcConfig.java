package com.web.novel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class MvcConfig  extends WebMvcConfigurerAdapter {
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/").setViewName("index");
            registry.addViewController("read.html").setViewName("read");
            registry.addViewController("index.html").setViewName("index");
            registry.addViewController("list.html").setViewName("list");
            registry.addViewController("download.html").setViewName("download");
            registry.addViewController("test.html").setViewName("test");
            registry.addViewController("cancel.html").setViewName("cancel");
            registry.addViewController("index1.html").setViewName("index1");
            registry.addViewController("success.html").setViewName("success");
            registry.addViewController("error.html").setViewName("error");

        }

    }
