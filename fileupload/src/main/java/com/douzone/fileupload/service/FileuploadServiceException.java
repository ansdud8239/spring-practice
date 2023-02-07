package com.douzone.fileupload.service;

public class FileuploadServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FileuploadServiceException(String msg) {
		super(msg);
	}
	
	public FileuploadServiceException() {
		super("Fileupload Exception Occurs");
	}
}
