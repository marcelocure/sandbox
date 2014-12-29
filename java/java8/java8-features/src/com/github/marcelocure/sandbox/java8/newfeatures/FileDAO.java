package com.github.marcelocure.sandbox.java8.newfeatures;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileDAO {
	public static List<File> getFiles() {
		return Arrays.asList(new File("C:/Temp/env_monitoring.py"),
							 new File("C:/Temp/extract_from_log.py"),
							 new File("C:/Temp/matrizdeadjacencias.py"),
							 new File("C:/Temp/binnary_search.py"),
							 new File("C:/Temp/check_port.py"),
							 new File("C:/Temp/code_metrics.rb"));
}
}