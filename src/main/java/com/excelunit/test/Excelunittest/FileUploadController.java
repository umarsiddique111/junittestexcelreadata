package com.excelunit.test.Excelunittest;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/upload")
public class FileUploadController {
	
	private static final Logger logger = Logger.getLogger(SpringBootApplication.class.getName());

    @RequestMapping(method = RequestMethod.POST )
    public String handleFileUpload(@RequestParam("user-file") MultipartFile multipartFile) throws IOException {
    	
        String name = multipartFile.getOriginalFilename();
        
        logger.log(Level.INFO,"File name: "+name);
        
        //todo save to a file via multipartFile.getInputStream()
        byte[] bytes = multipartFile.getBytes();
        logger.log(Level.INFO,"File uploaded content:\n"+ new String(bytes));
       
        return "file uploaded";
    }
}