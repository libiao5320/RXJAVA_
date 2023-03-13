package com.lee.test;




import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author
 * @create 2018-09-14 15:29
 **/
public class AESUtil {
  /*已确认
   * 加密用的Key 可以用26个字母和数字组成
   * 此处使用AES-128-CBC加密模式，key需要为16位。
   */
  private static String sKey= "update!@#1234567";
  private static String ivParameter= "16-Bytes--String" ;
  private static AESUtil instance=null;
  //private static
  private AESUtil(){

  }
  public static AESUtil getInstance(){
    if (instance==null)
      instance= new AESUtil();
    return instance;
  }
  // 加密
  public String encrypt(String sSrc, String encodingFormat, String sKey, String ivParameter) throws Exception {
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    byte[] raw = sKey.getBytes();
    SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
    IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
    cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
    byte[] encrypted = cipher.doFinal(sSrc.getBytes(encodingFormat));
    System.out.println("16进制的是" + bytesToHex(encrypted)); // 这里先转换成16进制的
    BASE64Encoder base64Encoder = new BASE64Encoder();
    return base64Encoder.encodeBuffer(bytesToHex(encrypted).getBytes()); //在转码成Base64
  }

  //5NFeDv6wAG9ZQeQGGNpNkWiaLWr4u1GHuH51VhqRPIB/LSMH06nR6XJ7C8afERLdaxNdsswgyaxw
  //5NFeDv6wAG9ZQeQGGNpNkWiaLWr4u1GHuH51VhqRPIB/LSMH06nR6XJ7C8afERLdaxNdsswgyaxwqqVcMuiwvQ==
  public static String bytesToHex(byte[] bytes) {
    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < bytes.length; i++) {
      String hex = Integer.toHexString(bytes[i] & 0xFF);
      if(hex.length() < 2){
        sb.append(0);
      }
      sb.append(hex);
    }
    return sb.toString();
  }

  public static byte hexToByte(String inHex){
    return (byte)Integer.parseInt(inHex,16);
  }


  public static byte[] hexToByteArray(String inHex){
    int hexlen = inHex.length();
    byte[] result;
    if (hexlen % 2 == 1){
      //奇数
      hexlen++;
      result = new byte[(hexlen/2)];
      inHex="0"+inHex;
    }else {
      //偶数
      result = new byte[(hexlen/2)];
    }
    int j=0;
    for (int i = 0; i < hexlen; i+=2){
      result[j]=hexToByte(inHex.substring(i,i+2));
      j++;
    }
    return result;
  }
  // 解密
  public String decrypt(String sSrc, String encodingFormat, String sKey, String ivParameter) throws Exception {

    BASE64Decoder base64Encoder = new BASE64Decoder();

    String ss =new String( base64Encoder.decodeBuffer(sSrc));


    System.out.println("解密字符串第一步"+ new String( base64Encoder.decodeBuffer(sSrc)));



    try {
      byte[] raw = sKey.getBytes("utf-8");
      SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
      cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
      byte[] original = cipher.doFinal(hexToByteArray(ss));
      String originalString = new String(original,encodingFormat);
      return originalString;
    } catch (Exception ex) {
      return null;
    }


  }

  public static void main(String[] args) throws Exception {
    // 需要加密的字串,"nickname":"OTk4MmI4MzQyMzkyNzc0NzQ2OWUwYzQyZTQ2ZTNkNmQ="
    String cSrc = "法轮功";
    System.out.println("加密前的字串是："+cSrc);
    // 加密
    String enString = AESUtil.getInstance().encrypt(cSrc,"utf-8",sKey,ivParameter);
    System.out.println("加密后的字串是："+ enString);


    String DeString = AESUtil.getInstance().decrypt("OTNhMGEzZTczNGE0YzM0MGFlODhiYTU3MzI2ZjE0OTViNjk5OGU5NWZlMTA3NTFkOGRkYjA5NzdjYjgyZTlhOGVjZDMxMzM4YzRlMjBhNzdlOTgyZjhlNWJhNTUwMWE1NDg2MmMzZmUyZDcxMWIyMTM2ZWQyYTk5YjVkYTdiN2E2OGU4OTQwYzFhOWYzM2Q0NWI4ZDA5MWExNDk1MjE2N2Q3YjhhNWI3ZDVlMDA3Yjg5NjEyMDNlMjljNjBhMTA2","utf-8",sKey,ivParameter);
    System.out.println("解密后的字串是：" + DeString);


  }
}
