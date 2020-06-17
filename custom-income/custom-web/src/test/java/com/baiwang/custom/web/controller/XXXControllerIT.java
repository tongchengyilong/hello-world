package com.baiwang.custom.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.baiwang.custom.common.model.MGAccountResqust;
import com.baiwang.custom.web.start.CustomApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomApplication.class)//这里的Application是springboot的启动类名
@WebAppConfiguration
public class XXXControllerIT {

	@Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
	@Test
	@Transactional
	@Rollback
	public void test() throws JsonProcessingException, Exception {
//		/maAccount/getAccountBill
		Long id =1l;
		Long a =1l;
		Long b =1l;
		MGAccountResqust resqust = new MGAccountResqust();
		resqust.setExt01("1");
		String jsonString = JSON.toJSONString(resqust);
		mockMvc.perform(MockMvcRequestBuilders.get("/maAccount/getAccountBill/{id}",id)
                .content(mapper.writeValueAsString(id))
                .content(mapper.writeValueAsString(a))
                .content(mapper.writeValueAsString(b))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
		
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print());

	}

}
