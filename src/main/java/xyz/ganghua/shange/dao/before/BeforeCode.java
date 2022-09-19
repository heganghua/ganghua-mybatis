package xyz.ganghua.shange.dao.before;

/**
 * 
 * @author ganghua
 * @date 2022/09/06
 */
public class BeforeCode {

    private String beforeCode;

    private String code;

    private String realEstateUnitNumber;

    public String getBeforeCode() {
        return beforeCode;
    }

    public void setBeforeCode(String beforeCode) {
        this.beforeCode = beforeCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRealEstateUnitNumber() {
        return realEstateUnitNumber;
    }

    public void setRealEstateUnitNumber(String realEstateUnitNumber) {
        this.realEstateUnitNumber = realEstateUnitNumber;
    }

    @Override
    public String toString() {
        return "BeforeCode [beforeCode=" + beforeCode + ", code=" + code + ", realEstateUnitNumber="
            + realEstateUnitNumber + "]";
    }

}
