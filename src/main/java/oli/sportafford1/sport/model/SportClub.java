package oli.sportafford1.sport.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sport_club")
@EntityListeners(AuditingEntityListener.class)
public class SportClub implements Serializable {

    @Id
    @Column(name = "sport_club_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sportClubId;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "birth_date", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date foundationDate;

    @OneToMany(mappedBy = "sportClub", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Sportsman> sportsmen;

    public SportClub() {
    }

    public SportClub(@NotBlank String name, Date foundationDate) {
        this.name = name;
        this.foundationDate = foundationDate;
    }

    public Long getSportClubId() {
        return sportClubId;
    }

    public void setSportClubId(Long sportClubId) {
        this.sportClubId = sportClubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(Date foundationDate) {
        this.foundationDate = foundationDate;
    }
}
