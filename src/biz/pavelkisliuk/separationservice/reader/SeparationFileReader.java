package biz.pavelkisliuk.separationservice.reader;

import biz.pavelkisliuk.separationservice.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code SeparationFileReader} class read special data for {@code TextComponent} creation
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see biz.pavelkisliuk.separationservice.model.TextComponent
 * @since 12.0
 */
public class SeparationFileReader {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Read data from file and return it as {@code List} of {@code String}
	 *
	 * @param path to file
	 * @return {@code List} of {@code String} red data
	 * @throws CustomException if wrong {@param path} or {@param path} is {@code null}
	 */
	public List<String> read(String path) throws CustomException {
		if ((path == null) ||
				(path.isEmpty()) ||
					(path.isBlank()) ||
						(Files.notExists(Paths.get(path)))) {
			throw new CustomException();
		}

		List<String> data;
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
			LOGGER.log(Level.TRACE, "Start to read data from file.");
			data = reader.lines().collect(Collectors.toList());
			LOGGER.log(Level.DEBUG, "Data red from file.");
		} catch (FileNotFoundException e) {
			LOGGER.log(Level.ERROR, "File didn't find", e);
			return new ArrayList<>();
		} catch (IOException e) {
			LOGGER.log(Level.ERROR, "Can't read file", e);
			return new ArrayList<>();
		}
		return data;
	}
}