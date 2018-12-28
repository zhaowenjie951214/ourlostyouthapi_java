package top.ourlostyouth.www.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bill_crystal_message_new")
public class MaterielMessge {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String palletNumber;
    private String crystalNo;
    private String outTreasury;
    private String outStore;
    private String outtreasuryDate;
    private String outtreasuryBatch;
    private String crystalModel;
    private String norms;
    private String warehousingLength;
    private String chipLength;
    private String weight;

    private String oblique;

    private String remarks;

    private String crystalGrey;

    private String chipGrey;

    private String lineMark;

    private String inspector;

    private String recorder;

    private String scratchClass;

    private String productiveDepartment;

    private long excelId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date addtime;

    private String crystalGroupNo;

    private Double actualLength;

    private long boolLinecutLoading;

    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }


    public String getPalletNumber() {
        return palletNumber;
    }

    public void setPalletNumber(String palletNumber) {
        this.palletNumber = palletNumber;
    }


    public String getCrystalNo() {
        return crystalNo;
    }

    public void setCrystalNo(String crystalNo) {
        this.crystalNo = crystalNo;
    }

    public String getCrystalGroupNo() {
        return crystalGroupNo;
    }

    public void setCrystalGroupNo(String crystalGroupNo) { this.crystalGroupNo = crystalGroupNo; }

    public String getOutTreasury() {
        return outTreasury;
    }

    public void setOutTreasury(String outTreasury) {
        this.outTreasury = outTreasury;
    }


    public String getOutStore() {
        return outStore;
    }

    public void setOutStore(String outStore) {
        this.outStore = outStore;
    }


    public String getOuttreasuryDate() {
        return outtreasuryDate;
    }

    public void setOuttreasuryDate(String outtreasuryDate) {
        this.outtreasuryDate = outtreasuryDate;
    }


    public String getOuttreasuryBatch() {
        return outtreasuryBatch;
    }

    public void setOuttreasuryBatch(String outtreasuryBatch) {
        this.outtreasuryBatch = outtreasuryBatch;
    }


    public String getCrystalModel() {
        return crystalModel;
    }

    public void setCrystalModel(String crystalModel) {
        this.crystalModel = crystalModel;
    }


    public String getNorms() {
        return norms;
    }

    public void setNorms(String norms) {
        this.norms = norms;
    }


    public String getWarehousingLength() {
        return warehousingLength;
    }

    public void setWarehousingLength(String warehousingLength) {
        this.warehousingLength = warehousingLength;
    }


    public String getChipLength() {
        return chipLength;
    }

    public void setChipLength(String chipLength) {
        this.chipLength = chipLength;
    }


    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }


    public String getOblique() {
        return oblique;
    }

    public void setOblique(String oblique) {
        this.oblique = oblique;
    }


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public String getCrystalGrey() {
        return crystalGrey;
    }

    public void setCrystalGrey(String crystalGrey) {
        this.crystalGrey = crystalGrey;
    }


    public String getChipGrey() {
        return chipGrey;
    }

    public void setChipGrey(String chipGrey) {
        this.chipGrey = chipGrey;
    }


    public String getLineMark() {
        return lineMark;
    }

    public void setLineMark(String lineMark) {
        this.lineMark = lineMark;
    }


    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }


    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }


    public String getScratchClass() {
        return scratchClass;
    }

    public void setScratchClass(String scratchClass) {
        this.scratchClass = scratchClass;
    }


    public String getProductiveDepartment() {
        return productiveDepartment;
    }

    public void setProductiveDepartment(String productiveDepartment) { this.productiveDepartment = productiveDepartment; }


    public long getExcelId() {
        return excelId;
    }

    public void setExcelId(long excelId) {
        this.excelId = excelId;
    }

    public Date getAddTime() { return addtime; }

    public void setAddTime(Date addtime) { this.addtime = addtime; }

    public Double getActualLength() { return actualLength; }

    public void setActualLength(Double actualLength) { this.actualLength = actualLength; }

    public long getBoolLinecutLoading() {
        return boolLinecutLoading;
    }

    public void setBoolLinecutLoading(long boolLinecutLoading) {
        this.boolLinecutLoading = boolLinecutLoading;
    }
}
