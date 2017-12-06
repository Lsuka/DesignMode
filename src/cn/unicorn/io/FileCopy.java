package cn.unicorn.io;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.err.println("error");
			System.exit(1);
		}
		File inFile = new File(args[0]);// 第一个参数为输入源文件
		if (!inFile.exists()) {
			System.err.println("源文件不存在");
			System.exit(1);
		}
		File outFile = new File(args[1]);
		if (!outFile.getParentFile().exists()) {
			outFile.getParentFile().mkdirs();
		}
		CopyUtil cu = new CopyUtil(new FileInputStream(inFile), new FileOutputStream(outFile));
		System.out.println("copy completely，speed：" + cu.copy());
		cu.close();
	}
}

/**
 * 定义一个文件拷贝的工具类
 * 
 * @author UNICORN
 *
 */
class CopyUtil implements Closeable {
	private InputStream input;
	private OutputStream output;

	public CopyUtil(InputStream input, OutputStream output) {
		this.input = input;
		this.output = output;
	}

	public long copy() throws IOException {
		long start = System.currentTimeMillis();
		byte data[] = new byte[1024];// 每次读取1024字节
		int temp = 0;// 保存每一个读取的字节数据
		while ((temp = this.input.read(data)) != -1) {
			this.output.write(data, 0, temp);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	@Override
	public void close() throws IOException {
		this.input.close();
		this.output.close();
	}
}