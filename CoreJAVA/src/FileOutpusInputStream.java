import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutpusInputStream {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("t1.txt");
		String s= "file handling by file output input class";
		byte[] b = s.getBytes();
		fos.write(b);
		fos.flush();
		fos.close();
		System.out.println("file writeen successfully");
		
		FileInputStream fis = new FileInputStream("t1.txt");
		int i;
		while((i = fis.read())!=-1) {
			System.out.print((char)i);
		}
	}
}
