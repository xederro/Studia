package pl.edu.pwr.student.Common.Data;

import pl.edu.pwr.student.Common.Enums.Role;
import pl.edu.pwr.tkubik.jp.shop.api.ICallback;

public class Person {
    private ICallback ic;

    public Role role;
    public Integer ID;
    public boolean isAvailable = true;
    private static Integer counter = 1;

    public Person(Role role, ICallback ic){
        this.role = role;
        this.ic = ic;
        this.ID = counter++;
    }
    public Person(){}

    public int getID() {
        return ID;
    }

    public Role getRole() {
        return role;
    }

    public ICallback getIc() {
        return ic;
    }


    public boolean isAvailable(){
        return isAvailable;
    }

    public void setAvailable(boolean ava){
        isAvailable = ava;
    }

    @Override
    public String toString() {
        return "ID=" + ID +  ", role=" + role;
    }
}
