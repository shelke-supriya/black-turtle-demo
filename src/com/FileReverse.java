package com;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FileReverse {

	/**
	 * Method to reverse the content
	 * @param inputStream content to be reversed
	 * @param outputStream reversed content
	 * @throws IOException
	 */
	public void reverseContent(InputStream inputStream, ByteArrayOutputStream outputStream) throws IOException {
		// Read the content from the input stream
		byte[] content = readAllBytes(inputStream);
		// Reverse the content
		for (int i = content.length - 1; i >= 0; i--) {
			outputStream.write(content[i]);
		}
	}

	public static void main(String[] args) {
		if (args.length ==0){
			System.out.println("Please specify input file path");
			System.exit(0);
		}
		String file_path = args[0];
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		File f = new File(file_path);
		try (FileInputStream fs = new FileInputStream(f)) {
			FileReverse fileReverser = new FileReverse();
			try {
				fileReverser.reverseContent(fs, outputStream);
				System.out.println("Reversed content: " + outputStream.toString(StandardCharsets.UTF_8.displayName()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	// Helper method to read file content.
	// Other third party helper methods available.
	// Apache byte[] bytes = IOUtils.toByteArray(is);
	private byte[] readAllBytes(InputStream inputStream) throws IOException {
		final int bufLen = 1024;
		byte[] buf = new byte[bufLen];
		int readLen;
		try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
			while ((readLen = inputStream.read(buf, 0, bufLen)) != -1)
				outputStream.write(buf, 0, readLen);
			return outputStream.toByteArray();
		} catch (IOException e) {
			throw e;
		}
	}
}