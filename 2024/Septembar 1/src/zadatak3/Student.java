package zadatak3;

public class Student implements Comparable<Student> {
    private String ime, prezime, alasNalog;

    public Student(String ime, String prezime, String alasNalog) {
        this.ime = ime;
        this.prezime = prezime;
        this.alasNalog = alasNalog;
    }

    @Override
    public int compareTo(Student o) {
        return this.alasNalog.compareTo(o.alasNalog);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            if(student.ime.equals(this.ime) && student.prezime.equals(this.prezime) && student.alasNalog.equals(this.alasNalog)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return ime + " " + prezime + " " + alasNalog;
    }
}
