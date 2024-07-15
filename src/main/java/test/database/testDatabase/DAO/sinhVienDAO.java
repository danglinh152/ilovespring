package test.database.testDatabase.DAO;

import test.database.testDatabase.entity.sinhVien;


import java.util.List;

public interface sinhVienDAO {
    public void save(sinhVien sv);

    public List<sinhVien> ListOfSV();

    public void delete(int id);

    public void update(sinhVien sv);

    public sinhVien getByID(int id);
}
