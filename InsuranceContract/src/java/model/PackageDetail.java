/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dell
 */
public class PackageDetail {

    private int packageDetailID;
    private String Age, benefit, describle, modelRules_Term;

    public PackageDetail() {
    }

    public PackageDetail(int packageDetailID, String Age, String benefit, String describle, String modelRules_Term) {
        this.packageDetailID = packageDetailID;
        this.Age = Age;
        this.benefit = benefit;
        this.describle = describle;
        this.modelRules_Term = modelRules_Term;
    }

    public int getPackageDetailID() {
        return packageDetailID;
    }

    public void setPackageDetailID(int packageDetailID) {
        this.packageDetailID = packageDetailID;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }

    public String getModelRules_Term() {
        return modelRules_Term;
    }

    public void setModelRules_Term(String modelRules_Term) {
        this.modelRules_Term = modelRules_Term;
    }

}
