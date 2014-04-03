package com.thirdblock.migo.common.web.action.dto;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

@JsonIgnoreProperties({ "bytes" })
public class FileMeta {
	
	private Logger logger = Logger.getLogger(FileMeta.class);

	private String fileName;
	private String fileSize;
	private String fileType;
	private String fileThumbUrl;

	private byte[] bytes;
	
	public FileMeta() {}

	public FileMeta(MultipartFile file) {
		this.fileName = file.getOriginalFilename();
		this.fileSize = file.getSize() / 1024 + "Kb";
		this.fileType = file.getContentType();
		try {
			this.bytes = file.getBytes();
		} catch (IOException e) {
			logger.warn("", e);
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public String getFileThumbUrl() {
		return fileThumbUrl;
	}

	public void setFileThumbUrl(String fileThumbUrl) {
		this.fileThumbUrl = fileThumbUrl;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

}
