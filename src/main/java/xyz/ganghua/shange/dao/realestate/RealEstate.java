package xyz.ganghua.shange.dao.realestate;

import com.alibaba.excel.annotation.ExcelProperty;

public class RealEstate {

    // 预编号
    @ExcelProperty("预编号")
    private String code;

    // 权力人
    @ExcelProperty("权力人")
    private String name;

    // 身份证
    @ExcelProperty("身份证")
    private String idNumber;

    // 联系电话
    @ExcelProperty("联系电话")
    private String tel;

    // 坐落
    @ExcelProperty("坐落")
    private String address;

    // 权属证件号
    @ExcelProperty("权属证件号")
    private String ownershipIdNumber;

    // 权属证件号发证时间
    @ExcelProperty("权属证件号发证时间")
    private String ownershipIssueDate;

    // 共有/共用权利人情况
    @ExcelProperty("共有/共用权利人情况")
    private String commonRightHolder;

    // 批准面积
    @ExcelProperty("批准面积")
    private String approvedArea;

    // 宗地面积
    @ExcelProperty("宗地面积")
    private String landArea;

    // 房屋竣工时间
    @ExcelProperty("房屋竣工时间")
    private String completionDate;

    // 幢号
    @ExcelProperty("幢号")
    private String buildingNumber;

    // 总层数
    @ExcelProperty("总层数")
    private String leveTotal;

    // 房屋结构
    @ExcelProperty("房屋结构")
    private String buildingStructure;

    // 占地面积
    @ExcelProperty("占地面积")
    private String floorSpace;

    // 建筑面积
    @ExcelProperty("建筑面积")
    private String coveredArea;

    // 权属来源
    @ExcelProperty("权属来源")
    private String ownershipSource;

    // 墙体归属东
    @ExcelProperty("墙体归属东")
    private String eastWall;

    // 墙体归属南
    @ExcelProperty("墙体归属南")
    private String southWall;

    // 西墙
    @ExcelProperty("西墙")
    private String westerWall;

    // 北墙
    @ExcelProperty("北墙")
    private String northWall;

    // 合计占地面积
    @ExcelProperty("合计占地面积")
    private String totalArea;

    // 合计建筑面积
    @ExcelProperty("合计建筑面积")
    private String totalConstructionArea;

    // 权属调查及不动产测量记事
    @ExcelProperty("权属调查及不动产测量记事")
    private String article;

    // 调查员
    @ExcelProperty("调查员")
    private String investigator;

    // 调查日期
    @ExcelProperty("调查日期")
    private String surveyDate;

    // 测量员
    @ExcelProperty("测量员")
    private String measurer;

    // 测量日期
    @ExcelProperty("测量日期")
    private String measurerDate;

    @Override
    public String toString() {
        return "RealEstate [code=" + code + ", name=" + name + ", idNumber=" + idNumber + ", tel=" + tel + ", address="
            + address + ", ownershipIdNumber=" + ownershipIdNumber + ", ownershipIssueDate=" + ownershipIssueDate
            + ", commonRightHolder=" + commonRightHolder + ", approvedArea=" + approvedArea + ", landArea=" + landArea
            + ", completionDate=" + completionDate + ", buildingNumber=" + buildingNumber + ", leveTotal=" + leveTotal
            + ", buildingStructure=" + buildingStructure + ", floorSpace=" + floorSpace + ", coveredArea=" + coveredArea
            + ", ownershipSource=" + ownershipSource + ", eastWall=" + eastWall + ", southWall=" + southWall
            + ", westerWall=" + westerWall + ", northWall=" + northWall + ", totalArea=" + totalArea
            + ", totalConstructionArea=" + totalConstructionArea + ", article=" + article + ", investigator="
            + investigator + ", surveyDate=" + surveyDate + ", measurer=" + measurer + ", measurerDate=" + measurerDate
            + "]";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnershipIdNumber() {
        return ownershipIdNumber;
    }

    public void setOwnershipIdNumber(String ownershipIdNumber) {
        this.ownershipIdNumber = ownershipIdNumber;
    }

    public String getOwnershipIssueDate() {
        return ownershipIssueDate;
    }

    public void setOwnershipIssueDate(String ownershipIssueDate) {
        this.ownershipIssueDate = ownershipIssueDate;
    }

    public String getCommonRightHolder() {
        return commonRightHolder;
    }

    public void setCommonRightHolder(String commonRightHolder) {
        this.commonRightHolder = commonRightHolder;
    }

    public String getApprovedArea() {
        return approvedArea;
    }

    public void setApprovedArea(String approvedArea) {
        this.approvedArea = approvedArea;
    }

    public String getLandArea() {
        return landArea;
    }

    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getLeveTotal() {
        return leveTotal;
    }

    public void setLeveTotal(String leveTotal) {
        this.leveTotal = leveTotal;
    }

    public String getBuildingStructure() {
        return buildingStructure;
    }

    public void setBuildingStructure(String buildingStructure) {
        this.buildingStructure = buildingStructure;
    }

    public String getFloorSpace() {
        return floorSpace;
    }

    public void setFloorSpace(String floorSpace) {
        this.floorSpace = floorSpace;
    }

    public String getCoveredArea() {
        return coveredArea;
    }

    public void setCoveredArea(String coveredArea) {
        this.coveredArea = coveredArea;
    }

    public String getOwnershipSource() {
        return ownershipSource;
    }

    public void setOwnershipSource(String ownershipSource) {
        this.ownershipSource = ownershipSource;
    }

    public String getEastWall() {
        return eastWall;
    }

    public void setEastWall(String eastWall) {
        this.eastWall = eastWall;
    }

    public String getSouthWall() {
        return southWall;
    }

    public void setSouthWall(String southWall) {
        this.southWall = southWall;
    }

    public String getWesterWall() {
        return westerWall;
    }

    public void setWesterWall(String westerWall) {
        this.westerWall = westerWall;
    }

    public String getNorthWall() {
        return northWall;
    }

    public void setNorthWall(String northWall) {
        this.northWall = northWall;
    }

    public String getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(String totalArea) {
        this.totalArea = totalArea;
    }

    public String getTotalConstructionArea() {
        return totalConstructionArea;
    }

    public void setTotalConstructionArea(String totalConstructionArea) {
        this.totalConstructionArea = totalConstructionArea;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getInvestigator() {
        return investigator;
    }

    public void setInvestigator(String investigator) {
        this.investigator = investigator;
    }

    public String getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(String surveyDate) {
        this.surveyDate = surveyDate;
    }

    public String getMeasurer() {
        return measurer;
    }

    public void setMeasurer(String measurer) {
        this.measurer = measurer;
    }

    public String getMeasurerDate() {
        return measurerDate;
    }

    public void setMeasurerDate(String measurerDate) {
        this.measurerDate = measurerDate;
    }

}
