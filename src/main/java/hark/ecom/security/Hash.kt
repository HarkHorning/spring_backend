package hark.ecom.security

import org.springframework.security.crypto.bcrypt.BCrypt
import java.security.MessageDigest
import java.security.SecureRandom

class Hash {
    companion object {
        @JvmStatic
        fun bCrypt(pwd: String): String {
//            return BCrypt.hashpw(pwd, BCrypt.gensalt())

            val random = SecureRandom.getInstance("SHA1PRNG")
            random.setSeed(1234L)

            return try {
                BCrypt.hashpw(pwd, BCrypt.gensalt(6, random))
            } catch (e: Exception) {
                // Handle exceptions like NoSuchAlgorithmException
                e.printStackTrace()
                ""
            }
        }
    }
}