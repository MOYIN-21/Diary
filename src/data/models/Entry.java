package data.models;

import java.time.LocalDateTime;

@Data
public class Entry {
    private int id;
    private String title;
    private String body;
    private LocalDateTime createdDate = LocalDateTime.now();
    private String OwnerName;


}
