package io.commercelayer.api.codegen.source.impl;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import io.commercelayer.api.codegen.ApiClientLicense;
import io.commercelayer.api.codegen.CodegenConfig;
import io.commercelayer.api.codegen.CodegenConfig.Module;
import io.commercelayer.api.codegen.source.ApiWriteable;
import io.commercelayer.api.codegen.source.SourceException;
import io.commercelayer.api.codegen.source.SourceWriter;

public class JPoetSourceWriter implements SourceWriter {

	private static final Logger logger = LoggerFactory.getLogger(JPoetSourceWriter.class);

	@Override
	public void write(ApiWriteable apiWriteable, String destDir) throws SourceException {

		if (apiWriteable == null)
			throw new SourceException("No classes to write");

		Path rootDir = Paths.get(destDir);
		logger.info("Root directory: {}", destDir);
		logger.info("Root package: {}", apiWriteable.getRootPackage());
		final Path classesDir = getOutputDirPath(rootDir, apiWriteable.getRootPackage());

		for (TypeSpec classe : apiWriteable.getClasses()) {

			logger.info("Writing file {}.java", classe.name);
			JavaFile javaFile = JavaFile.builder(apiWriteable.getRootPackage(), classe)
				.skipJavaLangImports(true)
//				.addFileComment()
				.build();

			try {
				javaFile.writeTo(rootDir);
				logger.info("File {}.java successfully written", classe.name);
			} catch (IOException ioe) {
				logger.error("Error writing source file [{}.{}]", javaFile.packageName, javaFile.typeSpec.name);
			}
			
			// License Header Management
			if (CodegenConfig.isPropertyEnabled(Module.Source, "license.header")) {
				Path outFilePath = classesDir.resolve(classe.name.concat(".java"));
				ApiClientLicense.insertLicenseHeader(outFilePath);
			}
			
		}

	}

	private Path getOutputDirPath(Path directory, String packageName) {
		Path outputDirectory = directory;
		if (!packageName.isEmpty()) {
			for (String packageComponent : packageName.split("\\.")) {
				outputDirectory = outputDirectory.resolve(packageComponent);
			}
		}
		return outputDirectory;
	}
	
}
