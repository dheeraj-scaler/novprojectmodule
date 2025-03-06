package com.lld.dp.prototype;

public class IntelligentStudent extends Student {
    int iq;

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public IntelligentStudent() {

    }

    public IntelligentStudent(IntelligentStudent is) {
        super(is);
        this.iq = is.iq;
    }

    @Override
    public IntelligentStudent clone() {
        return new IntelligentStudent(this);
    }
}
