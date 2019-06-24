package com.iconfluence.sms.mapper;

import com.iconfluence.sms.model.IcSmsUser;
import com.iconfluence.sms.util.CommonUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

  @Autowired
  IcSmsUserMapper icSmsUserMapper;

  @Before
  public void init() {
    System.out.println("-----------start-----------");
  }

  @Test
  public void insert() {
    IcSmsUser user = new IcSmsUser();
    try {
      user.setGid("1");
      user.setName("test");
      user.setCode("test");
      user.setPassword(CommonUtil.encodeByMd5("test"));
      user.setPid("");
      user.setRid("");
      user.setStatus("");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    Assert.assertEquals(1, icSmsUserMapper.insert(user));
  }

  @After
  public void end() {
    System.out.println("-----------end-----------");
  }
}
