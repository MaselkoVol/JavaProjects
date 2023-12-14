package Patient;

public class Patient {
    private int id, medcardNum;
    private String surname, name, patronymic;
    private String address, phoneNum, diagnosis;


    public Patient(int id, int medcardNum, String surname, String name, String patronymic,
                   String address, String phoneNum, String diagnosis) {
        this.id = id;
        this.medcardNum = medcardNum;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.phoneNum = phoneNum;
        this.diagnosis = diagnosis;
    }
    public Patient () {
        this(0, 0, "0", "0", "0", "0", "0", "0");
    }

    public boolean hasDiagnosis (String diagnosis) {
        if (this.diagnosis.compareTo(diagnosis) == 0) return true;
        return false;
    }

    public boolean isMedcardNumInRange (int from, int to) {
        return this.medcardNum > from && this.medcardNum < to;
    }

    public boolean doesPhoneNumStartsWithDigit (char digit) {
        int i = 0;
        for (i = 0; i < phoneNum.length(); i++) {
            if (phoneNum.charAt(i) >= '0' && phoneNum.charAt(i) <= '9') break;
        }
        if (i == phoneNum.length()) return false;
        return phoneNum.charAt(i) == digit;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedcardNum() {
        return medcardNum;
    }

    public void setMedcardNum(int mediacalCardNum) {
        this.medcardNum = mediacalCardNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", medcardNum=" + medcardNum +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
