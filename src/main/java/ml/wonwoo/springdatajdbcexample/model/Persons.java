package ml.wonwoo.springdatajdbcexample.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class Persons {

    @Id
    private Long id;

    private String name;

    private String desc;

    private LocalDateTime time;

    public Persons(String name, String desc, LocalDateTime time) {
        this.name = name;
        this.desc = desc;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", time=" + time +
                '}';
    }
}

