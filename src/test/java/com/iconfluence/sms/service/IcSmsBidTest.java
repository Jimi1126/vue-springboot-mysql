package com.iconfluence.sms.service;

import com.iconfluence.sms.model.IcSmsBid;
import com.iconfluence.sms.service.impl.IcSmsBidServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IcSmsBidTest {
  
  @Autowired
  private IcSmsBidServiceImpl service;

  @Test
  public void add() {
    try {
      service.insert(new IcSmsBid("", "2019", "", "test", "test", "test", "test", "test", "test", "test"));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}