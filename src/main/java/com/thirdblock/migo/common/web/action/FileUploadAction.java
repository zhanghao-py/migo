package com.thirdblock.migo.common.web.action;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.thirdblock.migo.common.web.action.dto.FileMeta;
import com.thirdblock.migo.core.config.SystemConfig;
import com.thirdblock.migo.core.util.RandomNumberGenernator;
import com.thirdblock.migo.core.web.action.BaseAction;

@Controller
@RequestMapping("common")
public class FileUploadAction extends BaseAction {
	
	@Autowired
	private SystemConfig config;
	
	public final static String FILES_KEY = "files";

	@RequestMapping(value = "upload", method = RequestMethod.GET )
	public ModelAndView upload() {
		ModelAndView modelAndView = new ModelAndView("commodity/upload");
		return modelAndView;
	}
	
	/**
	 * 上传一组文件
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST )
	@ResponseBody
	public List<FileMeta> upload(MultipartHttpServletRequest request) {
		
		LinkedList<FileMeta> files = (LinkedList<FileMeta>) session.getAttribute(FILES_KEY);
		
		if (files == null) {
			files = new LinkedList<FileMeta>();
			session.setAttribute(FILES_KEY, files);
		}
		
		Iterator<MultipartFile> iter = request.getFileMap().values().iterator();
		
		while (iter.hasNext()) {
			MultipartFile file = iter.next();
			
			if (files.size() >= 10) {
				files.pop();
			}
			
			String filename = getFileName(file.getOriginalFilename());
			String outputPath = getOutputPath(filename);
			File outputFile = new File(outputPath.toString());
			
			FileMeta fileMeta = new FileMeta(file);
			fileMeta.setFileThumbUrl(filename);
			
			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(), outputFile);
			} catch (IOException e) {
				logger.info("", e);
			}
			
			files.add(fileMeta);
		}
		
		return files;
	}
	
	private String getOutputPath(String filename) {
		StringBuilder outputPath = new StringBuilder();
		outputPath.append(config.getImageDirectoryPath()).append(filename);
		return outputPath.toString();
	}

	private String getFileName(String originalFilename) {
		StringBuilder filename = new StringBuilder();
		filename.append(RandomNumberGenernator.next());
		filename.append(".");
		filename.append(StringUtils.substringAfterLast(originalFilename, "."));
		return filename.toString();
	}

}
