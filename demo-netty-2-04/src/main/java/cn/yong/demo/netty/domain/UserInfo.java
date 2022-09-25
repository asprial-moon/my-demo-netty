package cn.yong.demo.netty.domain;

/**
 * @author Line
 * @desc
 * @date 2022/9/26
 */
public class UserInfo {
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private String workAddress;

    public UserInfo(String name, Integer age, String sex, String address, String workAddress) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.workAddress = workAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", workAddress='" + workAddress + '\'' +
                '}';
    }
}
