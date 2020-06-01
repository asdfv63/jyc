/**
 * <p>CodecUtil </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright(c) 2017</p>
 * <p>Company: www.zto.com</p>
 */
package com.jyc.zeus.common.util;

import com.jyc.zeus.common.enums.StatusCodeEnum;
import com.jyc.zeus.common.exception.BusinessException;
import com.jyc.zeus.common.exception.ErrorCodeException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;

/**
 * <p>Class: CodecUtil </p>
 * <p>Description: 对String进行编码处理</p>
 *
 * @author jyc
 * @version 1.0
 * @date 2019-05-06
 */
public class CodecUtil {
    private CodecUtil(){
    }

    /**
     * 将字符串 UTF-8 编码
     *
     * @param str
     * @return
     */
    public static String encodeForUTF8(String str) {
        return encode(str, "UTF-8");
    }

    /**
     * 将字符串编码
     *
     * @param str
     * @return
     */
    public static String encode(String str, String charset) {
        String target;
        try {
            target = URLEncoder.encode(str, charset);
        } catch (UnsupportedEncodingException e) {
            throw new BusinessException(StatusCodeEnum.PARAMETERS_VALID, "CodecUtil.encode编码异常");
        }
        return target;
    }

    /**
     * 将字符串 UTF-8 解码
     *
     * @param str
     * @return
     */
    public static String decodeForUTF8(String str) {
        return decode(str, "UTF-8");
    }

    /**
     * 将字符串解码
     *
     * @param str
     * @return
     */
    public static String decode(String str, String charset) {
        String target;
        try {
            target = URLDecoder.decode(str, charset);
        } catch (UnsupportedEncodingException e) {
            throw new ErrorCodeException(e, StatusCodeEnum.PARAMETERS_VALID, "CodecUtil.encode编码异常", str);
        }
        return target;
    }

    /**
     * 将字符串 Base64 编码
     *
     * @param str
     * @return
     */
    public static String encodeForBase64(String str) {
        return Base64.encodeBase64String(str.getBytes());
    }

    /**
     * 将字符串 Base64 编码
     *
     * @param str
     * @return
     */
    public static String encodeForBase64(byte[] str) {
        return Base64.encodeBase64String(str);
    }

    /**
     * 将字符串 Base64 解码
     *
     * @param str
     * @return
     */
    public static String decodeForBase64(String str) {
        return new String(Base64.decodeBase64(str.getBytes()));
    }

    /**
     * 将字符串 MD5 加密
     *
     * @param str
     * @return
     */
    public static String encryptForMD5(String str) {
        return DigestUtils.md5Hex(str);
    }

    /**
     * 将字符串 SHA 加密
     *
     * @param str
     * @return
     */
    public static String encryptForSHA(String str) {
        return DigestUtils.sha512Hex(str);
    }

    /**
     * 创建随机数
     *
     * @param count
     * @return
     */
    public static String createRandomNumber(int count) {
        return RandomStringUtils.randomNumeric(count);
    }

    /**
     * 获取UUID（32位）
     *
     * @return
     */
    public static String createUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    /**
     * <p>
     * 将文件编码为BASE64字符串
     * </p>
     * <p>
     * 大文件慎用，可能会导致内存溢出
     * </p>
     *
     * @param filePath 文件绝对路径
     * @return
     * @throws Exception
     */
    public static String encodeFile(String filePath) throws IOException {
        byte[] bytes = fileToByte(filePath);
        return encodeForBase64(bytes);
    }

    /**
     * <p>
     * BASE64字符串转回文件
     * </p>
     *
     * @param filePath 文件绝对路径
     * @param base64   编码字符串
     * @throws Exception
     */
    public static void decodeToFile(String filePath, String base64) throws IOException {
        byte[] bytes = decodeForBase64(base64).getBytes();
        byteArrayToFile(bytes, filePath);
    }

    /**
     * <p>
     * 文件转换为二进制数组
     * </p>
     *
     * @param filePath 文件路径
     * @return
     * @throws Exception
     */
    public static byte[] fileToByte(String filePath) throws IOException {
        return Files.readAllBytes(Paths.get(filePath));
    }

    /**
     * <p>
     * 二进制数据写文件
     * </p>
     *
     * @param bytes    二进制数据
     * @param filePath 文件生成目录
     */
    public static void byteArrayToFile(byte[] bytes, String filePath) throws IOException {
        InputStream in = new ByteArrayInputStream(bytes);
        File destFile = new File(filePath);
        if (!destFile.getParentFile().exists()) {
            destFile.getParentFile().mkdirs();
        }
        if(destFile.createNewFile()) {
            Files.copy(in, Paths.get(filePath), ATOMIC_MOVE);
        }else{
            throw new IOException("CREATE FILE ERROR FILENAME"+destFile.getName());
        }
    }

}
