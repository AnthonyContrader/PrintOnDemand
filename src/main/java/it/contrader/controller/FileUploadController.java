package it.contrader.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/order")
public class FileUploadController {
  //public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
  public String UploadPage(Model model) {
	  return "uploadview";
  }
  @PostMapping("/upload")
  public String upload(HttpServletRequest request,@RequestParam("img") MultipartFile[] immagine) {
	   for (MultipartFile file : immagine) {
		  try {
			  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
			  LocalDateTime now = LocalDateTime.now();
			  String datacorrente=dtf.format(now);
			  String conc= "src/main/webapp/immaginisalvate/" + datacorrente;			  
			  Path path = Paths.get(conc);
			  File ffile=new File(path.toString()+"/"+file.getOriginalFilename());
			  ffile.setReadable(true);
			  ffile.setWritable(true);
			  ffile.setExecutable(true);
			  request.getSession().setAttribute("path", path);
			  Files.createDirectories(path);
			  path=Paths.get(conc,file.getOriginalFilename());
			  Files.createFile(path.toAbsolutePath());
			  Files.write(path, file.getBytes());
			  request.getSession().setAttribute("path",path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	  request.getSession().setAttribute("uploaded",true);
	  return "updateorder";
  }
  
  
}

