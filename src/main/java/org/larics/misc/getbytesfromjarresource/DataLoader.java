package org.larics.misc.getbytesfromjarresource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StreamUtils;

@Component
public class DataLoader {
	// Commented lines don't work!!!

//	private Path resourceLocation;
	private String resourceLocation;

//	@Autowired
//	public DataLoader(@Value("${resource.location}") String resourceLocation) {
//		this.resourceLocation = Paths.get(resourceLocation);
//	}
	@Autowired
	public DataLoader(@Value("${resource.location}") String resourceLocation) {
		this.resourceLocation = resourceLocation;
	}

	@PostConstruct
	private void loadData() throws IOException {
		// Commented lines don't work!!!

		//		System.out.println("resource = " + resourceLocation
//				+ File.separator + "1.jpg");
//		System.out.println("resource = "
//				+ Paths.get(resourceLocation.toUri()).resolve("1.jpg"));
		System.out.println("resource = " + resourceLocation
				+ "/" + "1.jpg");

//		InputStream input = getClass().getClassLoader()
//				.getResourceAsStream(resourceLocation
//						+ File.separator + "1.jpg");
		InputStream input = getClass().getClassLoader()
				.getResourceAsStream(resourceLocation
						+ "/" + "1.jpg");
		System.out.println("InputStream input = " + input);

		byte[] bytes = FileCopyUtils.copyToByteArray(input);
		System.out.println("Data loaded! " + bytes.length);
	}
}
