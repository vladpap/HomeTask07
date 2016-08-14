package ru.sbt.plugin;

import javax.crypto.*;
import java.security.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

public class PluginEncriptClassLoader extends ClassLoader {
    private final String algorithm;
    private final String securityKey;
    private final String pluginRootDirectory;

    public PluginEncriptClassLoader(String pluginRootDirectory, String securityKey) {
        this.securityKey = securityKey;
        this.pluginRootDirectory = pluginRootDirectory;
        this.algorithm = "RC4";
    }

    @Override
    public Class<?> loadClass(String name){

        String fileName = this.pluginRootDirectory + name.replace(".", "/").concat(".dat");
        Path path = Paths.get(fileName);
        byte[] data;
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new PluginManagerException("Error load file:" + name, e);
        }
        byte[] encriptData = new byte[0];
        try {
            encriptData = this.decrypt(data, securityKey);
        } catch (Exception e) {
            throw new PluginManagerException("Error encripted file: " + name, e);
        }

        return defineClass(name, encriptData, 0, encriptData.length);
    }

    private byte[] decrypt(byte[] toDecrypt, String key) throws Exception {
        // create a binary key from the argument key (seed)
        SecureRandom sr = new SecureRandom(key.getBytes());
        KeyGenerator kg = KeyGenerator.getInstance(algorithm);
        kg.init(sr);
        SecretKey sk = kg.generateKey();

        // do the decryption with that key
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, sk);
        byte[] decrypted = cipher.doFinal(toDecrypt);

        return decrypted;
    }
}
