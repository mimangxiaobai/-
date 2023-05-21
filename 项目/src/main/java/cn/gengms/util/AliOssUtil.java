package cn.gengms.util;

import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Part;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;

public class AliOssUtil {

	// Endpoint以杭州为例，其它Region请按实际情况填写。
	private static final String endpoint = "https://oss-accelerate.aliyuncs.com";
	// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
	private static final String accessKeyId = "";
	private static final String accessKeySecret = "";
	private static final String bucketName = "521h";

	public static String upload(Part file) throws IOException {
		OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
		System.out.println(ossClient);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		// 获取文件名
		System.out.println("------");
		System.out.println(file);
		String fileName = file.getSubmittedFileName();
// 获取文件后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
// 最后上传生成的文件名
		String finalFileName = System.currentTimeMillis() + "" + new SecureRandom().nextInt(0x0400) + suffixName;
// oss中的文件夹名
		String objectName = sdf.format(new Date()) + "/" + finalFileName;
// 创建上传文件的元信息，可以通过文件元信息设置HTTP header(设置了才能通过返回的链接直接访问)。
		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentType("image/jpg");
// 文件上传
		ossClient.putObject(bucketName, objectName, file.getInputStream(), objectMetadata);
// 设置URL过期时间为1小时。
		Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000 * 10000);
		String url = ossClient.generatePresignedUrl(bucketName, objectName, expiration).toString();
		url = url.split("[?]")[0];
		ossClient.shutdown();
		System.out.println(url);
		return url;
	}

}
