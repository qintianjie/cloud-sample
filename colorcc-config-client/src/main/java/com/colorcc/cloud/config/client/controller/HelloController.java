/**
 * 
 */
package com.colorcc.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Duoduo (tianjieqin@126.com)
 * @date   2016年12月9日-上午12:57:18
 *
 */
@RefreshScope
@RestController
public class HelloController {
	
	@Value("${message:Hello default}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }

}
