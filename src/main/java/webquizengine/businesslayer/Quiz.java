package webquizengine.businesslayer;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message="title can't be empty")
    @NotBlank(message="title can't be empty")
    private String title;

    @NotNull(message="question can't be empty")
    @NotBlank(message="question can't be empty")
    private String text;

    @NotNull(message="possible answers can't be empty")
    @Size(min = 2, message="there must be at least 2 possible answers")
    @ElementCollection
    private List<String> options;

    @ElementCollection
    @NotNull(message="there must be at least 1 correct answer")
    @Size(min = 1, message="there must be at least 1 correct answer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> answer;

    @ManyToOne
    @JsonIgnore
    private User owner;

    public Quiz() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", options=" + options +
                ", answer=" + answer +
                '}';
    }
}
