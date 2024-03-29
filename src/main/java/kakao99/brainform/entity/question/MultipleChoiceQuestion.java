package kakao99.brainform.entity.question;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.anwer.MultipleChoiceAnswer;
import kakao99.brainform.entity.anwer.YesOrNoAnswer;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "multiplechoice_question")
public class MultipleChoiceQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;


    private Integer num;
    private String question;

    private Integer count;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private String choice5;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @OneToMany(mappedBy = "multipleChoiceQuestion", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<MultipleChoiceAnswer> multipleChoiceAnswers;

    public void setChoice(String o, String o1, String o2, String o3, String o4) {
        this.choice1 = o;
        this.choice2 = o1;
        this.choice3 = o2;
        this.choice4 = o3;
        this.choice5 = o4;
    }
}
