package com.project.data.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "general_table")
public class GeneralTable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "asset")
    private String asset;

    @Column(name = "period")
    private String period;

    @Column(name = "nameOfTable")
    private String nameOfTable;

    public GeneralTable() {
    }

    public GeneralTable(String asset, String period) {
        this.asset = asset;
        this.period = period;
        this.nameOfTable = asset.toLowerCase() + "_" + period;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getNameOfTable() {
        return nameOfTable;
    }

    public void setNameOfTable(String nameOfTable) {
        this.nameOfTable = nameOfTable;
    }

    @Override
    public String toString() {
        return "GeneralTable{" +
                "id=" + id +
                ", asset='" + asset + '\'' +
                ", period='" + period + '\'' +
                ", nameOfTable='" + nameOfTable + '\'' +
                '}';
    }
}
