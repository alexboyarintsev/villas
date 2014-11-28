package main.com.villas.db.dto;

/**
 * Created by aboyarintsev on 16.11.2014.
 */
public class ReservationDto {

    private String firstName;
    private String lastName;
    private String passportNo;
    private String phone;
    private String email;
    private String dateStart;
    private String dateFinish;
    private long villaId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(String dateFinish) {
        this.dateFinish = dateFinish;
    }

    public long getVillaId() {
        return villaId;
    }

    public void setVillaId(long villaId) {
        this.villaId = villaId;
    }
}
