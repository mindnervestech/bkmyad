package controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FilenameUtils;
import play.Play;
import play.data.DynamicForm;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData.FilePart;

public class UploadImageFileController extends Controller { 

	final static String rootDir = Play.application().configuration().getString("adimage.storage.path");
	  static {
      createRootDir();
}

public static void createRootDir() {
      File file = new File(rootDir);
      if (!file.exists()) {
              file.mkdir();
      }
}
	
	@Transactional(readOnly=false)
	public static Result savegeneralImg() throws IOException {
	
		/*String fileName = null;
		String filenamedbpath = null;
		
		play.mvc.Http.MultipartFormData.FilePart docFile;
		play.mvc.Http.MultipartFormData body = request().body()
				.asMultipartFormData();
		docFile = body.getFile("fupfile");

		if (docFile != null) {
			fileName = docFile.getFilename();
			File file = docFile.getFile();
			final String FILE_PATH = Play.application().configuration()
					.getString("storage.path");
			File f = new File(FILE_PATH + fileName);
			filenamedbpath = FILE_PATH + File.separator + fileName;
			Files.copy(file.toPath(), f.toPath(),
					java.nio.file.StandardCopyOption.REPLACE_EXISTING);
			flash("Success", "File Uploaded successfully");
		
		*/
		
		
		DynamicForm form = DynamicForm.form().bindFromRequest();
		FilePart picture = request().body().asMultipartFormData().getFile("file");
		
		
		createDir(rootDir);
		 String fileName = picture.getFilename();
		 if(FilenameUtils.getExtension(fileName).equals("jpg")){
		 String ThumbnailImage = rootDir + File.separator +"Logo_thumbnail."+FilenameUtils.getExtension(fileName);
         String originalFileName = rootDir + File.separator +"Original_image."+FilenameUtils.getExtension(fileName);
		 
         File src = picture.getFile();
         OutputStream out = null;
         BufferedImage image = null;
         File f = new File(ThumbnailImage);
         System.out.println(originalFileName);
         try {
                  BufferedImage originalImage = ImageIO.read(src);
                        Thumbnails.of(originalImage)
                            .size(220, 220)
                            .toFile(f);
                            File _f = new File(originalFileName);
                            Thumbnails.of(originalImage).scale(1.0).
                            toFile(_f);
         } catch (FileNotFoundException e) {
                 e.printStackTrace();
         } catch (IOException e) {
                 e.printStackTrace();
         } finally {
                 try {
                         if(out != null) out.close();
                 } catch (IOException e) {
                         e.printStackTrace();
                 }
         }
 		File filepath = new File(originalFileName);
 		System.out.println("filepath:"+filepath);
 		return ok(filepath);
	}else{
		System.out.println("in else");
		String fileNameDoc = null;
		String filenamedbpath = null;
		
		play.mvc.Http.MultipartFormData.FilePart docFile;
		play.mvc.Http.MultipartFormData body = request().body()
				.asMultipartFormData();
		docFile = body.getFile("file");

		if (docFile != null) {
			fileNameDoc = docFile.getFilename();
			File file = docFile.getFile();
			final String FILE_PATH = Play.application().configuration()
					.getString("storage.path");
			File f = new File(FILE_PATH + fileNameDoc);
			filenamedbpath = FILE_PATH + File.separator + fileNameDoc;
			Files.copy(file.toPath(), f.toPath(),
					java.nio.file.StandardCopyOption.REPLACE_EXISTING);
			flash("Success", "File Uploaded successfully");
			return ok("");
	}
	}
		return null;
}

	
	public static void createDir(String rootDir) {
        File file3 = new File(rootDir);
        if (!file3.exists()) {
                file3.mkdirs();
        }
	}
}