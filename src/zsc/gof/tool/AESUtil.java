package zsc.gof.tool;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class AESUtil {
    /**
     * 加密/解密的算法和模式
     * 算法：AES
     * 模式：ECB
     * 补码方式：PKCS5Padding
     */
    private static final String ENCRYPT_TYPE = "AES/ECB/PKCS5Padding";
    private static final String CHARSET = "utf-8";
    private static final String ALGORITHM = "AES";
    private static final String KEY = "zsccloudteam2018";

    /**
     * AES加密方法
     *
     * @param content 需要加密的内容
     * @param key 加密密钥
     * @return 加密结果，字符串形式
     * @throws Exception 加密过程中可能出现的各种异常
     */
    public static String encrypt(String content, String key) throws Exception {
//        密钥为空
        if (key == null || key.trim().equals("")) {
            //Log.e(AESUtil.class.getSimpleName(), "加密失败：密钥内容为空");
            return null;
        }
//        密钥不是为16位
        if (key.length() != 16) {
            //Log.e(AESUtil.class.getSimpleName(), "加密失败：密钥长度须为16位");
            return null;
        }
//        加密内容为空
        if (content == null || content.trim().equals("")) {
            //Log.e(AESUtil.class.getSimpleName(), "加密失败：加密内容为空");
            return null;
        }

        byte[] rawBytes = key.getBytes(CHARSET);
        SecretKeySpec keySpec = new SecretKeySpec(rawBytes, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ENCRYPT_TYPE);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptBytes = cipher.doFinal(content.getBytes(CHARSET));

        //使用Base64进行二次加密
        return Base64.encodeToString(encryptBytes, Base64.DEFAULT);
    }

    public static String encrypt(String content) throws Exception {
        return encrypt(content, KEY);
    }

    /**
     * AES解密方法
     *
     * @param content 需要解密的内容
     * @param key 解密密钥
     * @return 解密结果，字符串形式
     * @throws Exception 解密过程中可能出现的各种异常
     */
    public static String decrypt(String content, String key) throws Exception {
        try {
//        密钥为空
            if (key == null || key.trim().equals("")) {
                //Log.e(AESUtil.class.getSimpleName(), "解密失败：密钥内容为空");
                return null;
            }
//        密钥不是为16位
            if (key.length() != 16) {
                //Log.e(AESUtil.class.getSimpleName(), "解密失败：密钥长度须为16位");
                return null;
            }
//        解密内容为空
            if (content == null || content.trim().equals("")) {
                //Log.e(AESUtil.class.getSimpleName(), "解密失败：解密内容为空");
                return null;
            }

            byte[] rawBytes = key.getBytes(CHARSET);
            SecretKeySpec keySpec = new SecretKeySpec(rawBytes, ALGORITHM);
            Cipher cipher = Cipher.getInstance(ENCRYPT_TYPE);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] encryptBytes = Base64.decode(content, Base64.DEFAULT);

            try {
                byte[] original = cipher.doFinal(encryptBytes);
                String originalString = new String(original, CHARSET);
                return originalString;
            } catch (Exception e) {
                //Log.e(AESUtil.class.getSimpleName(), "解密失败：" + e.toString());
                return null;
            }
        } catch (Exception ex) {
            //Log.e(AESUtil.class.getSimpleName(), "解密失败：" + ex.toString());
            return null;
        }
    }

    public static String decrypt(String content) throws Exception {
        return decrypt(content, KEY);
    }

    public static void main(String[] args) throws Exception {
        /*
         * 此处使用AES-128-ECB加密模式，key需要为16位。
         */
        String key = "zorveezhenniubi1";
        // 需要加密的字串
        String content = "api=login&id=1&type=ios";

        // 加密
        String enString = AESUtil.encrypt(content, key);
        System.out.println("加密后的字串是：" + enString);

        // 解密
        String deString = AESUtil.decrypt(enString, key);
        System.out.println("解密后的字串是：" + deString);
    }
}