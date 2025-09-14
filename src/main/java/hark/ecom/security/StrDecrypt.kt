package hark.ecom.security

class StrDecrypt(private val encryptionKey: String, private val iv: String) {

    fun decrypt(string: String): String {
        try {
            return "temp"
        } catch (e: Exception) {
            throw Exception("Error during decryption: ${e.message}", e)
        }
    }
}