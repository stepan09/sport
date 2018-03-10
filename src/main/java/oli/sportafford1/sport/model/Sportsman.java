package oli.sportafford1.sport.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sportsman")
@EntityListeners(AuditingEntityListener.class)
public class Sportsman implements Serializable {
    @Id
    @Column(name = "sportsman_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sportsmanId;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "birth_date", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date birthDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "coach_has_sportsman", joinColumns = @JoinColumn(name = "sportsman_sportsman_id", referencedColumnName = "sportsman_id"),
    inverseJoinColumns = @JoinColumn(name = "coach_coach_id", referencedColumnName = "coach_id"))
    private List<Coach> coaches;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "sportsman_has_kind_of_sport", joinColumns = @JoinColumn(name = "sportsman_sportsman_id", referencedColumnName = "sportsman_id"),
    inverseJoinColumns = @JoinColumn(name = "kind_of_sport_id", referencedColumnName = "id"))
    private List<SportKind> sportKinds;

    @ManyToOne
    @JoinColumn(name = "sport_club_sport_club_id", nullable = false)
    private SportClub sportClub;

    public Sportsman() {
    }

    public Sportsman(Long sportsmanId, @NotBlank String lastName, @NotBlank String firstName, String middleName, Date birthDate) {
        this.sportsmanId = sportsmanId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
    }

    public Sportsman(@NotBlank String lastName, @NotBlank String firstName, String middleName, Date birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
    }

    public Long getSportsmanId() {
        return sportsmanId;
    }

    public void setSportsmanId(Long sportsmanId) {
        this.sportsmanId = sportsmanId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
