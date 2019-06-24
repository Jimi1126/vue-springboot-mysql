package com.iconfluence.sms.util;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CommonUtil {
    public static String encodeByMd5(String string) throws NoSuchAlgorithmException, UnsupportedEncodingException {
      // 确定计算方法
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      Base64.Encoder base64Encoder = Base64.getEncoder();
      // 加密字符串
      return base64Encoder.encodeToString(md5.digest(string.getBytes(StandardCharsets.UTF_8)));
    }

    public static File saveFile(String name, MultipartFile multFile) throws IOException {
      String indexFileName = ResourceUtils.getURL("").getPath().replace("%20"," ").replace('\\', '/') + "/excel";
      File indexFile = new File(indexFileName);
      if (!indexFile.exists()) {
        indexFile.mkdirs();
      }
      File uploadFile = new File(indexFileName + "/" + name);
      multFile.transferTo(uploadFile);
      return uploadFile;
    }
}
