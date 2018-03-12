package zsc.gof.tool;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class AESUtil {
    /**
     * ����/���ܵ��㷨��ģʽ
     * �㷨��AES
     * ģʽ��ECB
     * ���뷽ʽ��PKCS5Padding
     */
    private static final String ENCRYPT_TYPE = "AES/ECB/PKCS5Padding";
    private static final String CHARSET = "utf-8";
    private static final String ALGORITHM = "AES";
    private static final String KEY = "zsccloudteam2018";

    /**
     * AES���ܷ���
     *
     * @param content ��Ҫ���ܵ�����
     * @param key ������Կ
     * @return ���ܽ�����ַ�����ʽ
     * @throws Exception ���ܹ����п��ܳ��ֵĸ����쳣
     */
    public static String encrypt(String content, String key) throws Exception {
//        ��ԿΪ��
        if (key == null || key.trim().equals("")) {
            //Log.e(AESUtil.class.getSimpleName(), "����ʧ�ܣ���Կ����Ϊ��");
            return null;
        }
//        ��Կ����Ϊ16λ
        if (key.length() != 16) {
            //Log.e(AESUtil.class.getSimpleName(), "����ʧ�ܣ���Կ������Ϊ16λ");
            return null;
        }
//        ��������Ϊ��
        if (content == null || content.trim().equals("")) {
            //Log.e(AESUtil.class.getSimpleName(), "����ʧ�ܣ���������Ϊ��");
            return null;
        }

        byte[] rawBytes = key.getBytes(CHARSET);
        SecretKeySpec keySpec = new SecretKeySpec(rawBytes, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ENCRYPT_TYPE);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptBytes = cipher.doFinal(content.getBytes(CHARSET));

        //ʹ��Base64���ж��μ���
        return Base64.encodeToString(encryptBytes, Base64.DEFAULT);
    }

    public static String encrypt(String content) throws Exception {
        return encrypt(content, KEY);
    }

    /**
     * AES���ܷ���
     *
     * @param content ��Ҫ���ܵ�����
     * @param key ������Կ
     * @return ���ܽ�����ַ�����ʽ
     * @throws Exception ���ܹ����п��ܳ��ֵĸ����쳣
     */
    public static String decrypt(String content, String key) throws Exception {
        try {
//        ��ԿΪ��
            if (key == null || key.trim().equals("")) {
                //Log.e(AESUtil.class.getSimpleName(), "����ʧ�ܣ���Կ����Ϊ��");
                return null;
            }
//        ��Կ����Ϊ16λ
            if (key.length() != 16) {
                //Log.e(AESUtil.class.getSimpleName(), "����ʧ�ܣ���Կ������Ϊ16λ");
                return null;
            }
//        ��������Ϊ��
            if (content == null || content.trim().equals("")) {
                //Log.e(AESUtil.class.getSimpleName(), "����ʧ�ܣ���������Ϊ��");
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
                //Log.e(AESUtil.class.getSimpleName(), "����ʧ�ܣ�" + e.toString());
                return null;
            }
        } catch (Exception ex) {
            //Log.e(AESUtil.class.getSimpleName(), "����ʧ�ܣ�" + ex.toString());
            return null;
        }
    }

    public static String decrypt(String content) throws Exception {
        return decrypt(content, KEY);
    }

    public static void main(String[] args) throws Exception {
        /*
         * �˴�ʹ��AES-128-ECB����ģʽ��key��ҪΪ16λ��
         */
        String key = "zorveezhenniubi1";
        // ��Ҫ���ܵ��ִ�
        String content = "api=login&id=1&type=ios";

        // ����
        String enString = AESUtil.encrypt(content, key);
        System.out.println("���ܺ���ִ��ǣ�" + enString);

        // ����
        String deString = AESUtil.decrypt(enString, key);
        System.out.println("���ܺ���ִ��ǣ�" + deString);
    }
}