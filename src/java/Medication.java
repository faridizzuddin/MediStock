
import java.sql.Date;
import java.util.Base64;

/**
 *
 * @author Fareed Dinn
 */
public class Medication {

    private int prID, prQty;
    private String prName;
    private String prExpDate;
    private byte[] prImage;
    private String prImageString;
    private int supplierID;
    private String supplierName;
    private String supplierEmail;
    private String storageLocation;
    private String supplierCompanyName;
    private String supplierPhNum;

    public int getPrId() {
        return this.prID;
    }

    public int getPrQty() {
        return this.prQty;
    }

    public String getPrName() {
        return this.prName;
    }

    public String getPrExpDate() {
        return this.prExpDate;
    }

    public void setPrID(int prID) {
        this.prID = prID;
    }

    public void setPrQty(int prQty) {
        this.prQty = prQty;
    }

    public void setPrName(String prName) {
        this.prName = prName;
    }

    public void setPrExpDate(String prExpDate) {
        this.prExpDate = prExpDate;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public String getSupplierCompanyName() {
        return supplierCompanyName;
    }

    public void setSupplierCompanyName(String supplierCompanyName) {
        this.supplierCompanyName = supplierCompanyName;
    }

    public String getSupplierPhNum() {
        return supplierPhNum;
    }

    public void setSupplierPhNum(String supplierPhNum) {
        this.supplierPhNum = supplierPhNum;
    }

    public byte[] getPrImage() {
        return prImage;
    }

    public void setPrImage(byte[] prImage) {
        this.prImage = prImage;
    }

    public String getPrImageString() {
        return Base64.getEncoder().encodeToString(this.prImage);
    }

    public void setPrImageString(String prImageString) {
        this.prImageString = prImageString;
    }

}
