package net.cctv3.chnqoodiaryservice.controller;

import net.cctv3.chnqoodiaryservice.config.MyConfig;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@RestController
public class FileUploaderAction {
    @Autowired
    MyConfig myConfig;

    @CrossOrigin
    @PostMapping("/fileUploader.action")
    public HashMap<String, Object> fileUploaderAction(@RequestParam MultipartFile file, HttpServletRequest request) {
        String idQoo = request.getParameter("idQoo");
        String originalFilename = file.getOriginalFilename();
        HashMap<String, Object> map = new HashMap<>();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        File dir = new File(String.format("%s/%s/%s", myConfig.getUploadRealPath(), myConfig.getEnvironment(), idQoo));
        if (!dir.exists()) {
            dir.mkdir();
        }
        String id = UUID.randomUUID().toString();
        try {
            File fileCache = new File(dir.getAbsolutePath(), String.format("%s%s", id, fileExtension));
            if (!fileCache.exists()) {
                fileCache.createNewFile();
            }
            fileCache.createNewFile();
            FileOutputStream fos = new FileOutputStream(fileCache);
            IOUtils.copy(file.getInputStream(), fos);
            fos.flush();
            fos.close();
            map.put("success", true);
            map.put("data", String.format("%s/%s/%s/%s%s", myConfig.getUploadCdnPath(), myConfig.getEnvironment(), idQoo, id, fileExtension));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}