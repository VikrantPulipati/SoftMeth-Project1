public class Roster {
    private Student[] roster;
    private int size;
    public int getSize() {
        return this.size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    private int find(Student student) {
        return 1;
    } // search the given student in roster
    private void grow() {} // increase the array capacity by 4
    public boolean add(Student student) {
        roster[size-1] = student;
        size++;
    } // add student to end of array
    public boolean remove(Student student) {
        return true;
    } // maintain the order after remove
    public boolean contains(Student student) {
        return true;
    } // if the student is in roster
    public void print() {} // print roster sorted by profiles
    public void printBySchoolMajor() {} // print roster sorted by school major
    public void printByStanding() {} // print roster sorted by standing
}