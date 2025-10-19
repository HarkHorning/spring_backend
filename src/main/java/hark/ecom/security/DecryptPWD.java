//package hark.ecom.security;
//
//import com.nimbusds.jose.JWEObject;
//import com.nimbusds.jose.crypto.DirectDecrypter; // For symmetric key
//import com.nimbusds.jose.crypto.RSADecrypter; // For asymmetric key
//import com.nimbusds.jwt.EncryptedJWT;
//import com.nimbusds.jwt.JWTClaimsSet;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DecryptPWD {
//
//    JWEObject jweObject = JWEObject.parse(jweString);
//
//    // For symmetric key decryption
//        jweObject.decrypt(new DirectDecrypter(secretKey));
//
//    // For asymmetric key decryption (replace with your private key)
//    // jweObject.decrypt(new RSADecrypter(privateKey));
//
//    EncryptedJWT encryptedJWT = (EncryptedJWT) jweObject;
//        return encryptedJWT.getJWTClaimsSet();
//}
