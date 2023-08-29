package gr.hua.dit.tax.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "contracts")
public class Contract{
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "notaryId")
    @NotNull(message = "Please enter the notary's id")
    @Digits(integer = 9, fraction = 2, message = "Id should not be greater than 9 digits")
    private int notaryId;

    @Column(name = "address", unique = true)
    @NotBlank(message = "Please enter the property's address")
    @Size(max = 30, message = "Addres should not be greater than 30 characters")
    private String address;

    @Column(name = "tax")
    @NotNull(message = "Please enter the tax")
    @Digits(integer = 9, fraction = 2, message = "Tax should not be greater than 9 digits")
    private int tax;

    @Column(name = "sellerdec")
    private boolean sellerDec = false;

    @Column(name = "buyerdec")
    private boolean buyerDec = false;

    //Susxethsh me ton pinaka users
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyerid", referencedColumnName = "id")
    @JsonManagedReference
    private Actor buyer;

    public Actor getBuyer() {
        return buyer;
    }

    public void setBuyer(Actor buyer) {
        this.buyer = buyer;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sellerid", referencedColumnName = "id")
    @JsonManagedReference
    private Actor seller;

    public Actor getSeller() {
        return seller;
    }

    public void setSeller(Actor seller) {
        this.seller = seller;
    }

    public Contract() {

    }

    public Contract(int notaryId, String address, int tax, boolean sellerDec, boolean buyerDec) {
        this.notaryId = notaryId;
        this.address = address;
        this.tax = tax;
        this.sellerDec = sellerDec;
        this.buyerDec = buyerDec;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getNotaryId() {
        return notaryId;
    }

    public void setNotaryId(int notaryId) {
        this.notaryId = notaryId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public boolean getSellerDec() {
        return sellerDec;
    }

    public void setSellerDec(boolean sellerDec) {
        this.sellerDec = sellerDec;
    }

    public boolean getBuyerDec() {
        return buyerDec;
    }

    public void setbuyerDec(boolean buyerDec) {
        this.buyerDec = buyerDec;
    }


    @Override
    public String toString() {
        return "Contract:\n" +
               "NotaryId: " + notaryId + "\n" +
               "Address" + address + "\n" +
               "Tax: " + tax + "\n " +
               "SellerDec" + sellerDec + "\n" +
               "BuyerDec: " + buyerDec;
    }

}