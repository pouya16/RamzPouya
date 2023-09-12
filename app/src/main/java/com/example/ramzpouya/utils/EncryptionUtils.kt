package com.example.ramzpouya.utils

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

class EncryptionUtils(private val context: Context) {
    private val KEY_NAME = "biometric_key"
    private val CIPHER_ALGORITHM = "AES/GCM/NoPadding"
    private val keyStore = KeyStore.getInstance("AndroidKeyStore").apply {
        load(null)
    }

    fun createKey() : SecretKey{
        val keyGenerator = KeyGenerator.getInstance(
            KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore"
        )
        val builder = KeyGenParameterSpec.Builder(
            KEY_NAME,
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
        )
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .setUserAuthenticationRequired(true) // Require fingerprint authentication
            .build()

        keyGenerator.init(builder)
        return keyGenerator.generateKey()
    }


    /*fun encryptData(dataToEncrypt: String, key: SecretKey): EncryptedData {
        val cipher = Cipher.getInstance(CIPHER_ALGORITHM)
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val encryptedData = cipher.doFinal(dataToEncrypt.toByteArray(Charsets.UTF_8))
        return EncryptedData(cipher.iv, encryptedData)
    }*/
}