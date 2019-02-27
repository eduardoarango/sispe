# sispe
app congif
http://java2db.com/servlets/aes-password-encryption-in-javascript-and-decryption-in-java-servlet



#44
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
<script>
function doSubmit() 
 var val = document.getElementById('pwd').value; //assign password to a variable
 var rkEncryptionKey = CryptoJS.enc.Base64.parse('u/Gu5posvwDsXUnV5Zaq4g==');
 var rkEncryptionIv = CryptoJS.enc.Base64.parse('5D9r9ZVzEYYgha93/aUK2w==');
 var utf8Stringified = CryptoJS.enc.Utf8.parse(val);
 var encrypted = CryptoJS.AES.encrypt(utf8Stringified.toString(), rkEncryptionKey, 
{mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7, iv: rkEncryptionIv});
 document.myform.pwd.value = encrypted.ciphertext.toString(CryptoJS.enc.Base64);
alert("Encrypted Password"+document.myform.pwd.value);
 form.submit();
}
 
</script>
</head>
<body>
<form method="post" name="myform" action="encrypturl" >
User name : <input type="text" name = "user" />
Password : <input type="password" name="pwd" id="pwd"/>
<input type="button" value="Submit" onClick="doSubmit()"/> 
</form>
</body>
</html>

-----  EncryptServlet.java

package controller;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Hex;

import net.iharder.Base64;

/**
 * Servlet implementation class EncryptServlet
 */
@WebServlet("/EncryptServlet")
public class EncryptServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
  throws ServletException, IOException {
 String name=request.getParameter("name");
 String password = request.getParameter("pwd");
 System.out.println("Encrypted password : "+password);
 try {
 String afterDecrypt = decrypt(password);
 /*String [] repl = afterDecrypt.replaceAll("..(?!$)", "$0 ").split(" ");
 for(String aa : repl) */
 
 byte[] bytes = Hex.decodeHex(afterDecrypt.toCharArray());
 System.out.println("Decrypted password : "+new String(bytes, "UTF-8"));
 } catch (Exception e) {
 e.printStackTrace();
 }
 
 }
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 doGet(request, response);
 }


public String decrypt(final String encrypted) throws Exception {

 try {
 SecretKey key = new SecretKeySpec(Base64.decode("u/Gu5posvwDsXUnV5Zaq4g=="), "AES");
 AlgorithmParameterSpec iv = new IvParameterSpec(Base64.decode("5D9r9ZVzEYYgha93/aUK2w=="));
 byte[] decodeBase64 = Base64.decode(encrypted);
 Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
 cipher.init(Cipher.DECRYPT_MODE, key, iv);
 return new String(cipher.doFinal(decodeBase64), "UTF-8");
 } catch (Exception e) {
 e.printStackTrace();
 throw new RuntimeException("This should not happen in production.", e);
 }
} 


}


*---------web.xml
<span style="font-family: Georgia, 'Times New Roman', 'Bitstream Charter', Times, serif;"><span style="font-size: 16px; white-space: normal;"> </span></span><?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
xmlns="http://java.sun.com/xml/ns/javaee" xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
 <display-name>CopyPayment2</display-name>
 <welcome-file-list>
 <welcome-file>index.jsp</welcome-file>
 </welcome-file-list>
 <servlet>
 <servlet-name>encrypt</servlet-name>
 <servlet-class>controller.EncryptServlet</servlet-class>
 </servlet>
 <servlet-mapping>
 <servlet-name>encrypt</servlet-name>
 <url-pattern>/encrypturl</url-pattern>
 </servlet-mapping>
 
</web-app>
