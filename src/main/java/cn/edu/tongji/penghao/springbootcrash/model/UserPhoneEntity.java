package cn.edu.tongji.penghao.springbootcrash.model;

import javax.persistence.*;

@Entity
@Table(name = "user_phone", schema = "springbootdemo", catalog = "")
public class UserPhoneEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "phone")
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPhoneEntity that = (UserPhoneEntity) o;

        if (id != that.id) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
