package home;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class FileUtilTest {
	
	public void runTest1() {
		String srcPathName = "D:/Project/JDev/workspace/emptyprj/bin/EmptyTest";
		String distPathName = "D:/Project/JDev/workspace/emptyprj/dist/EmptyTest";
		String classFileName = "EmptyTest.class";
		
		Path srcPath = Paths.get(srcPathName);
		Path distPath = Paths.get(distPathName);
		try {
			
			Path srcFilePath = srcPath.resolve(classFileName);
			Path tarFilePath = distPath.resolve(classFileName);
			
			Path parentDir = tarFilePath.getParent();
			if (parentDir != null && Files.notExists(parentDir)) {
				Files.createDirectories(parentDir);				
			}
			
			Files.copy(srcFilePath, tarFilePath, StandardCopyOption.REPLACE_EXISTING);
			
			System.out.println("파일복사가 완료 되었습니다.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void runTest2() {
		String srcPathName = "D:/Project/JDev/workspace/emptyprj/bin/EmptyTest";
		String distPathName = "D:/Project/JDev/workspace/emptyprj/dist/EmptyTest";
		String classFileName = "EmptyTest.class";
				
		try {
			
			File srcPath = new File(srcPathName + "/" + classFileName);
			File distPath = new File(distPathName + "/" + classFileName);
			
			File parentDir = new File(distPath.getParent());
			if (parentDir != null && !parentDir.exists()) {
				Files.createDirectories(parentDir.toPath());	
			}
			
			Files.copy(srcPath.toPath(), distPath.toPath(), StandardCopyOption.REPLACE_EXISTING);
			
			System.out.println("파일복사가 완료 되었습니다.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void runTest3() {
		
		Path path = Paths.get("d:/Document/test.txt");
		try {
			BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
			
			String line = "";
			while((line = br.readLine()) != null) {
				if (line.isEmpty())
					continue;
				
				System.out.println(line);
			}						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileUtilTest fileUtil = new FileUtilTest();
		//fileUtil.runTest1();
		//fileUtil.runTest2();
		fileUtil.runTest3();
	}

}
