package Customer;

import java.util.Date;

public class Customer {
    private long id;
    private String fullname;
    private String email;
    private String address;
    private Date createAt;
    public Customer(long id, String fullname, String email, String address, Date createAt) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.createAt = createAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }




}
