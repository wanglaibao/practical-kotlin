package com.laibao.kotlin.simple.mybatis

import com.github.pagehelper.PageHelper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
class SpringBootKotlinApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<SpringBootKotlinApplication>(*args)
        }
    }

    @Bean
    fun pageHelper() : PageHelper {
        System.out.println("=========MyBatisConfiguration.pageHelper()");
        val pageHelper = PageHelper();
        val p = Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }

}