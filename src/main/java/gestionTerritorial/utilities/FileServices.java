package gestionTerritorial.utilities;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServices {

  public String uploadMultipleFiles(MultipartFile[] files) {
    String fileName = null;
    String message = "";
    String absoluteFilePath = "";
    String workingDirectory = System.getProperty("user.dir");

    if (files != null && files.length > 0) {
      for (int i = 0; i < files.length; i++) {
        try {
          fileName = files[i].getOriginalFilename();
          byte[] bytes = files[i].getBytes();
          absoluteFilePath = workingDirectory + File.separator + fileName;
          BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(absoluteFilePath)));
          buffStream.write(bytes);
          buffStream.close();
          message += "You have successfully uploaded " + fileName + " in the directoty " + absoluteFilePath + " \n";
        } catch (Exception e) {
          message = "You failed to upload " + fileName + ": " + e.getMessage() + "\n";
        }
      }
    } else {
      message = "Unable to upload. File is empty.";
    }
    return message;
  }

}
