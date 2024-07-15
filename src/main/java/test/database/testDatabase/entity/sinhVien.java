package test.database.testDatabase.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sinhvien")
public class sinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ten")
    private String ten;

    public sinhVien() {

    }

    public sinhVien(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public sinhVien(String ten) {
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setten(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "sinhVien{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                '}';
    }
}
