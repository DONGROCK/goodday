package com.ohgiraffers.file;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class FileDTO {

    private String originFileName;
    private String savedName;
    private String filePath;
    private String fileDescription;

    public FileDTO(String originFileName, String savedName, String fileDescription) {
        this.originFileName = originFileName;
        this.savedName = savedName;
        this.fileDescription = fileDescription;
    }
}
