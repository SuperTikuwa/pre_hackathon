package database.src;

public  class GetData {
    public String dt;
    public String detail;
    public String person;
    public String deadline;

    public GetData(String register_day, String detail, String person_name, String deadline) {
        this.dt = register_day;
        this.detail = detail;
        this.person = person_name;
        this.deadline = deadline;
    }

    public String getdetail(){
        return this.deadline;
    }
}
