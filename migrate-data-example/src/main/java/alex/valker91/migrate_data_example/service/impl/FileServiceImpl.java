package alex.valker91.migrate_data_example.service.impl;

import alex.valker91.migrate_data_example.model.TextLineEntity;
import alex.valker91.migrate_data_example.repository.TextLineRepository;
import alex.valker91.migrate_data_example.service.FileService;
import alex.valker91.migrate_data_example.util.FileReaderUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService {

    @Value("${file.path}")
    private String filePath;

    private final TextLineRepository textLineRepository;
    private final FileReaderUtil fileReaderUtil;

    public FileServiceImpl(TextLineRepository textLineRepository, FileReaderUtil fileReaderUtil) {
        this.textLineRepository = textLineRepository;
        this.fileReaderUtil = fileReaderUtil;
    }

    @Override
    public String processFile() {
        try {
            List<TextLineEntity> lines = fileReaderUtil.readLines(filePath);
            List<TextLineEntity> savedlines = textLineRepository.saveAll(lines);
            List<Long> ids = savedlines.stream()
                    .map(TextLineEntity::getId)
                    .collect(Collectors.toList());
            String idsString = ids.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            return "File processed successfully: " + idsString;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error processing file";
        }
    }
}
