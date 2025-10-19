package hark.ecom.security

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


class StrDecrypt(private val encryptionKey: String, private val iv: String) {

    fun decrypt(string: String): String {
        try {
            return "temp"
        } catch (e: Exception) {
            throw Exception("Error during decryption: ${e.message}", e)
        }
    }
}