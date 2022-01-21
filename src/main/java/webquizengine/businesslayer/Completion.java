package webquizengine.businesslayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Completion {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long completionId;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    //    @ManyToOne
    private long id;

//    @ElementCollection
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private List<Integer> answer;

    @CreationTimestamp
    private LocalDateTime completedAt;

    public Completion() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getCompletionId() {
        return completionId;
    }

    public void setCompletionId(long completionId) {
        this.completionId = completionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public Quiz getQuiz() {
//        return quiz;
//    }
//
//    public void setQuiz(Quiz quiz) {
//        this.quiz = quiz;
//    }
//
//    public List<Integer> getAnswer() {
//        return answer;
//    }
//
//    public void setAnswer(List<Integer> answer) {
//        this.answer = answer;
//    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    @Override
    public String toString() {
        return "Completion{" +
                "completionId=" + completionId +
                ", user=" + user +
                ", id=" + id +
                ", completedAt=" + completedAt +
                '}';
    }
}

