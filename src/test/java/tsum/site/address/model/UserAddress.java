package tsum.site.address.model;

public class UserAddress {
    public final String city ;
    public final String street;
    public final String houseNum ;
    public final String apartmentNum;


    public UserAddress(String city, String street, String houseNum, String apartmentNum){
        this.city = city;
        this.street = street;
        this.houseNum = houseNum;
        this.apartmentNum = apartmentNum;
    }
}
