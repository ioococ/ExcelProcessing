package ink.onei.excel.controller;

import com.alibaba.excel.EasyExcel;
import ink.onei.excel.domain.WaterSheet;
import ink.onei.excel.domain.payload.UploadFileResponse;
import ink.onei.excel.service.FileStorageService;
import ink.onei.excel.service.excel.WaterSheetListener;
import ink.onei.excel.service.util.Rabbit;
import ink.onei.excel.service.util.RedisCache;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private Rabbit rabbit;

    @Autowired
    private RedisCache redisCache;


    @PostMapping("/import")
    public UploadFileResponse importFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {

//        if (multipartFile.isEmpty() || !multipartFile.getContentType().contains("sheet")) return new UploadFileResponse();

        String[] dateS = FilenameUtils.getBaseName(multipartFile.getOriginalFilename()).split("-");

        EasyExcel.read(multipartFile.getInputStream(), WaterSheet.class,
                        new WaterSheetListener(null, rabbit, dateS))
                .headRowNumber(3).sheet().doRead();

//        String fileName = fileStorageService.storeFile(multipartFile);

        return new UploadFileResponse(multipartFile.getContentType(), multipartFile.getSize());
//        return new UploadFileResponse(fileName, fileDownloadUri, multipartFile.getContentType(), multipartFile.getSize());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
