package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Company extends BaseEntity{
    @Id @GeneratedValue
    private Long companyId;

    private String name;

    private String address;

}
