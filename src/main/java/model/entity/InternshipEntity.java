package model.entity;

import jakarta.persistence.*;

import java.sql.Date;

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

        if (id != that.id) return false;
        if (noteTech != null ? !noteTech.equals(that.noteTech) : that.noteTech != null) return false;
        if (noteCom != null ? !noteCom.equals(that.noteCom) : that.noteCom != null) return false;
        if (mission != null ? !mission.equals(that.mission) : that.mission != null) return false;
        if (cdc != null ? !cdc.equals(that.cdc) : that.cdc != null) return false;
        if (visitSheet != null ? !visitSheet.equals(that.visitSheet) : that.visitSheet != null) return false;
        if (evalSheet != null ? !evalSheet.equals(that.evalSheet) : that.evalSheet != null) return false;
        if (webSurvey != null ? !webSurvey.equals(that.webSurvey) : that.webSurvey != null) return false;
        if (report != null ? !report.equals(that.report) : that.report != null) return false;
        if (defense != null ? !defense.equals(that.defense) : that.defense != null) return false;
        if (startedDate != null ? !startedDate.equals(that.startedDate) : that.startedDate != null) return false;
        if (endedDate != null ? !endedDate.equals(that.endedDate) : that.endedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (noteTech != null ? noteTech.hashCode() : 0);
        result = 31 * result + (noteCom != null ? noteCom.hashCode() : 0);
        result = 31 * result + (mission != null ? mission.hashCode() : 0);
        result = 31 * result + (cdc != null ? cdc.hashCode() : 0);
        result = 31 * result + (visitSheet != null ? visitSheet.hashCode() : 0);
        result = 31 * result + (evalSheet != null ? evalSheet.hashCode() : 0);
        result = 31 * result + (webSurvey != null ? webSurvey.hashCode() : 0);
        result = 31 * result + (report != null ? report.hashCode() : 0);
        result = 31 * result + (defense != null ? defense.hashCode() : 0);
        result = 31 * result + (startedDate != null ? startedDate.hashCode() : 0);
        result = 31 * result + (endedDate != null ? endedDate.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "ID_COMPANY", referencedColumnName = "ID", nullable = false)
    public CompanyEntity getCompanyByIdCompany() {
        return companyByIdCompany;
    }

    public void setCompanyByIdCompany(CompanyEntity companyByIdCompany) {
        this.companyByIdCompany = companyByIdCompany;
    }
}
