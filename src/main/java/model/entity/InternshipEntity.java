package model.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "INTERNSHIP", schema = "tutordb", catalog = "")
public class InternshipEntity {
    private int id;
    private String noteTech;
    private String noteCom;
    private String mission;
    private Byte cdc;
    private Byte visitSheet;
    private Byte evalSheet;
    private Byte webSurvey;
    private Byte report;
    private Byte defense;
    private Date startedDate;
    private Date endedDate;
    private InternEntity internByIdIntern;
    private TutorEntity tutorByIdTutor;
    private CompanyEntity companyByIdCompany;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NOTE_TECH", nullable = true, length = 10)
    public String getNoteTech() {
        return noteTech;
    }

    public void setNoteTech(String noteTech) {
        this.noteTech = noteTech;
    }

    @Basic
    @Column(name = "NOTE_COM", nullable = true, length = 10)
    public String getNoteCom() {
        return noteCom;
    }

    public void setNoteCom(String noteCom) {
        this.noteCom = noteCom;
    }

    @Basic
    @Column(name = "MISSION", nullable = true, length = 300)
    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    @Basic
    @Column(name = "CDC", nullable = true)
    public Byte getCdc() {
        return cdc;
    }

    public void setCdc(Byte cdc) {
        this.cdc = cdc;
    }

    @Basic
    @Column(name = "VISIT_SHEET", nullable = true)
    public Byte getVisitSheet() {
        return visitSheet;
    }

    public void setVisitSheet(Byte visitSheet) {
        this.visitSheet = visitSheet;
    }

    @Basic
    @Column(name = "EVAL_SHEET", nullable = true)
    public Byte getEvalSheet() {
        return evalSheet;
    }

    public void setEvalSheet(Byte evalSheet) {
        this.evalSheet = evalSheet;
    }

    @Basic
    @Column(name = "WEB_SURVEY", nullable = true)
    public Byte getWebSurvey() {
        return webSurvey;
    }

    public void setWebSurvey(Byte webSurvey) {
        this.webSurvey = webSurvey;
    }

    @Basic
    @Column(name = "REPORT", nullable = true)
    public Byte getReport() {
        return report;
    }

    public void setReport(Byte report) {
        this.report = report;
    }

    @Basic
    @Column(name = "DEFENSE", nullable = true)
    public Byte getDefense() {
        return defense;
    }

    public void setDefense(Byte defense) {
        this.defense = defense;
    }

    @Basic
    @Column(name = "STARTED_DATE", nullable = true)
    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    @Basic
    @Column(name = "ENDED_DATE", nullable = true)
    public Date getEndedDate() {
        return endedDate;
    }

    public void setEndedDate(Date endedDate) {
        this.endedDate = endedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternshipEntity that = (InternshipEntity) o;
        return id == that.id && Objects.equals(noteTech, that.noteTech) && Objects.equals(noteCom, that.noteCom) && Objects.equals(mission, that.mission) && Objects.equals(cdc, that.cdc) && Objects.equals(visitSheet, that.visitSheet) && Objects.equals(evalSheet, that.evalSheet) && Objects.equals(webSurvey, that.webSurvey) && Objects.equals(report, that.report) && Objects.equals(defense, that.defense) && Objects.equals(startedDate, that.startedDate) && Objects.equals(endedDate, that.endedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, noteTech, noteCom, mission, cdc, visitSheet, evalSheet, webSurvey, report, defense, startedDate, endedDate);
    }

    @ManyToOne
    @JoinColumn(name = "ID_INTERN", referencedColumnName = "ID", nullable = false)
    public InternEntity getInternByIdIntern() {
        return internByIdIntern;
    }

    public void setInternByIdIntern(InternEntity internByIdIntern) {
        this.internByIdIntern = internByIdIntern;
    }

    @ManyToOne
    @JoinColumn(name = "ID_TUTOR", referencedColumnName = "ID", nullable = false)
    public TutorEntity getTutorByIdTutor() {
        return tutorByIdTutor;
    }

    public void setTutorByIdTutor(TutorEntity tutorByIdTutor) {
        this.tutorByIdTutor = tutorByIdTutor;
    }

    @ManyToOne
    @JoinColumn(name = "ID_COMPANY", referencedColumnName = "ID", nullable = false)
    public CompanyEntity getCompanyByIdCompany() {
        return companyByIdCompany;
    }

    public void setCompanyByIdCompany(CompanyEntity companyByIdCompany) {
        this.companyByIdCompany = companyByIdCompany;
    }
}
