package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.FileReverse;

public class FileReverseTest {

	@Test
	public void testReverseContent() throws IOException {

		// given
		String originalContent = "Please, reverse!";
		String expectedReversedContent = "!esrever ,esaelP";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(originalContent.getBytes());
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		FileReverse fileReverser = new FileReverse();

		// when
		fileReverser.reverseContent(inputStream, outputStream);

		// then
		String reversedContent = outputStream.toString();
		assertEquals(expectedReversedContent, reversedContent);
	}
}
