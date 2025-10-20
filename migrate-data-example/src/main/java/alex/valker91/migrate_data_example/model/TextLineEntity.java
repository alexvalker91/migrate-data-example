package alex.valker91.migrate_data_example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "text_lines")
public class TextLineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text_line")
    private String textLine;

    public TextLineEntity() {}

    public TextLineEntity(String textLine) {
        this.textLine = textLine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
